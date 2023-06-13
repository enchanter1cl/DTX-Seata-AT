package com.erato.goodsservice.service.impl;

import com.erato.goodsservice.dao.GoodsInfoDao;
import com.erato.goodsservice.entity.GoodsInfo;
import com.erato.goodsservice.service.GoodsInfoService;
import com.erato.goodsservice.util.PageQueryUtil;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (GoodsInfo)表服务实现类
 *
 * @author makejava
 * @since 2023-06-11 23:01:24
 */
@Service("goodsInfoService")
@Slf4j
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Resource
    private GoodsInfoDao goodsInfoDao;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Boolean deStock(long id) {
        if (id == 0L) {
            log.info("goods id: {}", id);
        }
        log.info("Seata全局事务id=================>{}", RootContext.getXID());
        return goodsInfoDao.deStock(id);
    }

    @Override
    public List<GoodsInfo> getGoodsPage(PageQueryUtil pageUtil) {
        return goodsInfoDao.findGoodsPage(pageUtil);

    }

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    @Override
    public GoodsInfo queryById(Long goodsId) {
        return this.goodsInfoDao.queryById(goodsId);
    }

    /**
     * 分页查询
     *
     * @param goodsInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<GoodsInfo> queryByPage(GoodsInfo goodsInfo, PageRequest pageRequest) {
        long total = this.goodsInfoDao.count(goodsInfo);
        return new PageImpl<>(this.goodsInfoDao.queryAllByLimit(goodsInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param goodsInfo 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsInfo insert(GoodsInfo goodsInfo) {
        this.goodsInfoDao.insert(goodsInfo);
        return goodsInfo;
    }

    /**
     * 修改数据
     *
     * @param goodsInfo 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsInfo update(GoodsInfo goodsInfo) {
        this.goodsInfoDao.update(goodsInfo);
        return this.queryById(goodsInfo.getGoodsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long goodsId) {
        return this.goodsInfoDao.deleteById(goodsId) > 0;
    }

}
