package com.erato.goodsservice.service;

import com.erato.goodsservice.entity.MallUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (MallUser)表服务接口
 *
 * @author makejava
 * @since 2023-06-12 15:05:06
 */
public interface MallUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    MallUser queryById(Long userId);

    /**
     * 分页查询
     *
     * @param mallUser    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<MallUser> queryByPage(MallUser mallUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param mallUser 实例对象
     * @return 实例对象
     */
    MallUser insert(MallUser mallUser);

    /**
     * 修改数据
     *
     * @param mallUser 实例对象
     * @return 实例对象
     */
    MallUser update(MallUser mallUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Long userId);

}
