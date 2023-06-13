package com.erato.orderservice.dao;

import com.erato.orderservice.entity.MallUserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 收货地址表(MallUserAddress)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-12 16:28:37
 */
@Mapper
public interface MallUserAddressDao {

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    MallUserAddress queryById(Long addressId);

    /**
     * 查询指定行数据
     *
     * @param mallUserAddress 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<MallUserAddress> queryAllByLimit(MallUserAddress mallUserAddress, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mallUserAddress 查询条件
     * @return 总行数
     */
    long count(MallUserAddress mallUserAddress);

    /**
     * 新增数据
     *
     * @param mallUserAddress 实例对象
     * @return 影响行数
     */
    int insert(MallUserAddress mallUserAddress);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MallUserAddress> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MallUserAddress> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MallUserAddress> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MallUserAddress> entities);

    /**
     * 修改数据
     *
     * @param mallUserAddress 实例对象
     * @return 影响行数
     */
    int update(MallUserAddress mallUserAddress);

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 影响行数
     */
    int deleteById(Long addressId);

}

