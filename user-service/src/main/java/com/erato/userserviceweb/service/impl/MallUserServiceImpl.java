package com.erato.userserviceweb.service.impl;

import com.erato.userserviceweb.dao.MallUserDao;
import com.erato.userserviceweb.entity.MallUser;
import com.erato.userserviceweb.service.MallUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (MallUser)表服务实现类
 *
 * @author makejava
 * @since 2023-06-12 15:05:06
 */
@Service("mallUserService")
public class MallUserServiceImpl implements MallUserService {
    @Resource
    private MallUserDao mallUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public MallUser queryById(Long userId) {
        return this.mallUserDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param mallUser    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<MallUser> queryByPage(MallUser mallUser, PageRequest pageRequest) {
        long total = this.mallUserDao.count(mallUser);
        return new PageImpl<>(this.mallUserDao.queryAllByLimit(mallUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param mallUser 实例对象
     * @return 实例对象
     */
    @Override
    public MallUser insert(MallUser mallUser) {
        this.mallUserDao.insert(mallUser);
        return mallUser;
    }

    /**
     * 修改数据
     *
     * @param mallUser 实例对象
     * @return 实例对象
     */
    @Override
    public MallUser update(MallUser mallUser) {
        this.mallUserDao.update(mallUser);
        return this.queryById(mallUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.mallUserDao.deleteById(userId) > 0;
    }
}
