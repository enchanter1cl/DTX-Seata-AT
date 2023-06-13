package com.erato.goodsservice.service.impl;


import com.erato.goodsservice.dao.GoodsCategoryDao;
import com.erato.goodsservice.entity.GoodsCategory;
import com.erato.goodsservice.service.GoodsCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * (GoodsCategory)表服务实现类
 *
 * @author makejava
 * @since 2023-06-08 22:42:29
 */
@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Resource
    private GoodsCategoryDao goodsCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    @Override
    public GoodsCategory queryById(Long categoryId) {
        return this.goodsCategoryDao.queryById(categoryId);
    }

    /**
     * 分页查询
     *
     * @param goodsCategory 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @Override
    public Page<GoodsCategory> queryByPage(GoodsCategory goodsCategory, PageRequest pageRequest) {
        long total = this.goodsCategoryDao.count(goodsCategory);
        return new PageImpl<>(this.goodsCategoryDao.queryAllByLimit(goodsCategory, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param goodsCategory 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsCategory insert(GoodsCategory goodsCategory) {
        this.goodsCategoryDao.insert(goodsCategory);
        return goodsCategory;
    }

    /**
     * 修改数据
     *
     * @param goodsCategory 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsCategory update(GoodsCategory goodsCategory) {
        this.goodsCategoryDao.update(goodsCategory);
        return this.queryById(goodsCategory.getCategoryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long categoryId) {
        return this.goodsCategoryDao.deleteById(categoryId) > 0;
    }
}
