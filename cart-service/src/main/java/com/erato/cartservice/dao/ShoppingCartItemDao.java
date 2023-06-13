package com.erato.cartservice.dao;

import com.erato.cartservice.entity.ShoppingCartItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (ShoppingCartItem)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-12 17:37:54
 */

@Mapper
public interface ShoppingCartItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cartItemId 主键
     * @return 实例对象
     */
    ShoppingCartItem queryById(Long cartItemId);

    /**
     * 查询指定行数据
     *
     * @param shoppingCartItem 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ShoppingCartItem> queryAllByLimit(ShoppingCartItem shoppingCartItem, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param shoppingCartItem 查询条件
     * @return 总行数
     */
    long count(ShoppingCartItem shoppingCartItem);

    /**
     * 新增数据
     *
     * @param shoppingCartItem 实例对象
     * @return 影响行数
     */
    int insert(ShoppingCartItem shoppingCartItem);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShoppingCartItem> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShoppingCartItem> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShoppingCartItem> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShoppingCartItem> entities);

    /**
     * 修改数据
     *
     * @param shoppingCartItem 实例对象
     * @return 影响行数
     */
    int update(ShoppingCartItem shoppingCartItem);

    /**
     * 通过主键删除数据
     *
     * @param cartItemId 主键
     * @return 影响行数
     */
    int deleteById(Long cartItemId);

}

