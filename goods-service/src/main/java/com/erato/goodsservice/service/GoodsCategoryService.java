package com.erato.goodsservice.service;


import com.erato.goodsservice.entity.GoodsCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (GoodsCategory)表服务接口
 *
 * @author makejava
 * @since 2023-06-08 22:42:29
 */
public interface GoodsCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    GoodsCategory queryById(Long categoryId);

    /**
     * 分页查询
     *
     * @param goodsCategory 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    Page<GoodsCategory> queryByPage(GoodsCategory goodsCategory, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param goodsCategory 实例对象
     * @return 实例对象
     */
    GoodsCategory insert(GoodsCategory goodsCategory);

    /**
     * 修改数据
     *
     * @param goodsCategory 实例对象
     * @return 实例对象
     */
    GoodsCategory update(GoodsCategory goodsCategory);

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 是否成功
     */
    boolean deleteById(Long categoryId);

}
