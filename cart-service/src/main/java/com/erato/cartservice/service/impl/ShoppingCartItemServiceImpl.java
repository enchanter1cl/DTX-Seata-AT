package com.erato.cartservice.service.impl;

import com.erato.cartservice.entity.ShoppingCartItem;
import com.erato.cartservice.dao.ShoppingCartItemDao;
import com.erato.cartservice.service.ShoppingCartItemService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ShoppingCartItem)表服务实现类
 *
 * @author makejava
 * @since 2023-06-12 17:37:54
 */
@Service("shoppingCartItemService")
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {
    @Resource
    private ShoppingCartItemDao shoppingCartItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cartItemId 主键
     * @return 实例对象
     */
    @Override
    public ShoppingCartItem queryById(Long cartItemId) {
        return this.shoppingCartItemDao.queryById(cartItemId);
    }

    /**
     * 分页查询
     *
     * @param shoppingCartItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ShoppingCartItem> queryByPage(ShoppingCartItem shoppingCartItem, PageRequest pageRequest) {
        long total = this.shoppingCartItemDao.count(shoppingCartItem);
        return new PageImpl<>(this.shoppingCartItemDao.queryAllByLimit(shoppingCartItem, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param shoppingCartItem 实例对象
     * @return 实例对象
     */
    @Override
    public ShoppingCartItem insert(ShoppingCartItem shoppingCartItem) {
        this.shoppingCartItemDao.insert(shoppingCartItem);
        return shoppingCartItem;
    }

    /**
     * 修改数据
     *
     * @param shoppingCartItem 实例对象
     * @return 实例对象
     */
    @Override
    public ShoppingCartItem update(ShoppingCartItem shoppingCartItem) {
        this.shoppingCartItemDao.update(shoppingCartItem);
        return this.queryById(shoppingCartItem.getCartItemId());
    }

    /**
     * 通过主键删除数据
     *
     * @param cartItemId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long cartItemId) {
        return this.shoppingCartItemDao.deleteById(cartItemId) > 0;
    }
}
