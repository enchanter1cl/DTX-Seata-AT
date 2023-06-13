package com.erato.orderservice.dao;

import com.erato.orderservice.entity.MallOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (MallOrder)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-12 16:29:42
 */
@Mapper
public interface MallOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    MallOrder queryById(Long orderId);

    /**
     * 查询指定行数据
     *
     * @param mallOrder 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<MallOrder> queryAllByLimit(MallOrder mallOrder, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mallOrder 查询条件
     * @return 总行数
     */
    long count(MallOrder mallOrder);

    /**
     * 新增数据
     *
     * @param mallOrder 实例对象
     * @return 影响行数
     */
    int insert(MallOrder mallOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MallOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MallOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MallOrder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MallOrder> entities);

    /**
     * 修改数据
     *
     * @param mallOrder 实例对象
     * @return 影响行数
     */
    int update(MallOrder mallOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 影响行数
     */
    int deleteById(Long orderId);

}

