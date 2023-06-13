package com.erato.goodsservice.service;

import com.erato.goodsservice.entity.GoodsInfo;
import com.erato.goodsservice.util.PageQueryUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (GoodsInfo)表服务接口
 *
 * @author makejava
 * @since 2023-06-11 23:01:24
 */
public interface GoodsInfoService {


    Boolean deStock(long id);

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    GoodsInfo queryById(Long goodsId);

    /**
     * 分页查询
     *
     * @param goodsInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<GoodsInfo> queryByPage(GoodsInfo goodsInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param goodsInfo 实例对象
     * @return 实例对象
     */
    GoodsInfo insert(GoodsInfo goodsInfo);

    /**
     * 修改数据
     *
     * @param goodsInfo 实例对象
     * @return 实例对象
     */
    GoodsInfo update(GoodsInfo goodsInfo);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    boolean deleteById(Long goodsId);

    List<GoodsInfo> getGoodsPage(PageQueryUtil pageUtil);



}
