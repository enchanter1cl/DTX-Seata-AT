package com.erato.orderservice.service.impl;

import com.erato.cartservicefeign.CartServiceFeign;
import com.erato.cloud.common.dto.Result;
import com.erato.goodsserviceapi.feign.GoodsServiceFeign;
import com.erato.orderservice.dao.MallOrderDao;
import com.erato.orderservice.entity.MallOrder;
import com.erato.orderservice.service.MallOrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * (MallOrder)表服务实现类
 *
 * @author makejava
 * @since 2023-06-12 16:29:43
 */
@Service("mallOrderService")
@Slf4j
public class MallOrderServiceImpl implements MallOrderService {
    @Resource
    private MallOrderDao mallOrderDao;

    @Autowired
    CartServiceFeign cartServiceFeign;

    @Autowired
    GoodsServiceFeign goodsServiceFeign;


    @Transactional
    @GlobalTransactional
    @Override
    public Boolean saveOrder(long cartId) {
        log.info("Seata全局事务id=================>{}", RootContext.getXID());

        //调用购物车服务-获取即将操作的goods_id
        Long goodsId = cartServiceFeign.getGoodsId(cartId);

        //减库存
        Boolean goodsRes = goodsServiceFeign.deStock(goodsId);

        //调cart-service 删除当前购物车数据
        Result<Boolean> cartRes = cartServiceFeign.deleteById(cartId);
        if (cartRes.getData() == null) {
            log.info("删除cart_item失败， delCartRes: {}", cartRes);
        }
        log.info("delCartRes: {}", cartRes);

        //执行下单逻辑
        if (goodsRes && cartRes.getData()) {

            MallOrder mallOrder = new MallOrder();
            mallOrder.setUserId(1L);
            mallOrder.setOrderNo("10000002");
            mallOrder.setOrderId(1L);
            mallOrder.setTotalPrice(9);
            mallOrder.setPayStatus(0);
            mallOrder.setPayType(0);
            mallOrder.setOrderStatus(0);
            mallOrder.setIsDeleted(0);
            mallOrder.setExtraInfo("etra info");
            mallOrder.setCreateTime(LocalDateTime.now());
            mallOrder.setUpdateTime(LocalDateTime.now());

            //向 order 新增一条数据
            int orderRes = mallOrderDao.insert(mallOrder);
            // 此处出现了异常
            //int i=1/0;
            if (orderRes > 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public MallOrder queryById(Long orderId) {
        return this.mallOrderDao.queryById(orderId);
    }

    /**
     * 分页查询
     *
     * @param mallOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<MallOrder> queryByPage(MallOrder mallOrder, PageRequest pageRequest) {
        long total = this.mallOrderDao.count(mallOrder);
        return new PageImpl<>(this.mallOrderDao.queryAllByLimit(mallOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param mallOrder 实例对象
     * @return 实例对象
     */
    @Override
    public MallOrder insert(MallOrder mallOrder) {
        this.mallOrderDao.insert(mallOrder);
        return mallOrder;
    }

    /**
     * 修改数据
     *
     * @param mallOrder 实例对象
     * @return 实例对象
     */
    @Override
    public MallOrder update(MallOrder mallOrder) {
        this.mallOrderDao.update(mallOrder);
        return this.queryById(mallOrder.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long orderId) {
        return this.mallOrderDao.deleteById(orderId) > 0;
    }

}
