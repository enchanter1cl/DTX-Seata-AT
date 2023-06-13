package com.erato.goodsservice.dao;


import com.erato.goodsservice.entity.GoodsInfo;
import com.erato.goodsservice.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (GoodsInfo)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-11 23:01:24
 */

@Mapper
public interface GoodsInfoDao {

    Boolean deStock(long id);

    List<GoodsInfo> findGoodsPage(PageQueryUtil pageUtil);

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    GoodsInfo queryById(Long goodsId);

    /**
     * 查询指定行数据
     *
     * @param goodsInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<GoodsInfo> queryAllByLimit(GoodsInfo goodsInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param goodsInfo 查询条件
     * @return 总行数
     */
    long count(GoodsInfo goodsInfo);

    /**
     * 新增数据
     *
     * @param goodsInfo 实例对象
     * @return 影响行数
     */
    int insert(GoodsInfo goodsInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<GoodsInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<GoodsInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<GoodsInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<GoodsInfo> entities);

    /**
     * 修改数据
     *
     * @param goodsInfo 实例对象
     * @return 影响行数
     */
    int update(GoodsInfo goodsInfo);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 影响行数
     */
    int deleteById(Long goodsId);

}

