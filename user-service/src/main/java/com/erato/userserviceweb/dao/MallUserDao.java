package com.erato.goodsservice.dao;

import com.erato.goodsservice.entity.MallUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (MallUser)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-12 15:05:05
 */
@Mapper
public interface MallUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    MallUser queryById(Long userId);

    /**
     * 查询指定行数据
     *
     * @param mallUser 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<MallUser> queryAllByLimit(MallUser mallUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mallUser 查询条件
     * @return 总行数
     */
    long count(MallUser mallUser);

    /**
     * 新增数据
     *
     * @param mallUser 实例对象
     * @return 影响行数
     */
    int insert(MallUser mallUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MallUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MallUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MallUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MallUser> entities);

    /**
     * 修改数据
     *
     * @param mallUser 实例对象
     * @return 影响行数
     */
    int update(MallUser mallUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Long userId);

}

