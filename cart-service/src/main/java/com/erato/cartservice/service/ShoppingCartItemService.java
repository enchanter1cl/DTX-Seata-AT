package com.erato.cartservice.service;

import com.erato.cartservice.entity.ShoppingCartItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ShoppingCartItem)表服务接口
 *
 * @author makejava
 * @since 2023-06-12 17:37:54
 */
public interface ShoppingCartItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param cartItemId 主键
     * @return 实例对象
     */
    ShoppingCartItem queryById(Long cartItemId);

    /**
     * 分页查询
     *
     * @param shoppingCartItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ShoppingCartItem> queryByPage(ShoppingCartItem shoppingCartItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param shoppingCartItem 实例对象
     * @return 实例对象
     */
    ShoppingCartItem insert(ShoppingCartItem shoppingCartItem);

    /**
     * 修改数据
     *
     * @param shoppingCartItem 实例对象
     * @return 实例对象
     */
    ShoppingCartItem update(ShoppingCartItem shoppingCartItem);

    /**
     * 通过主键删除数据
     *
     * @param cartItemId 主键
     * @return 是否成功
     */
    boolean deleteById(Long cartItemId);

}
