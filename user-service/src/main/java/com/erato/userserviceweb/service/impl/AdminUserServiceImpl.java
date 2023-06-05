package com.erato.userserviceweb.service.impl;

import com.erato.userserviceweb.dao.AdminUserDao;
import com.erato.userserviceweb.entity.AdminUser;
import com.erato.userserviceweb.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (AdminUser)表服务实现类
 *
 * @author makejava
 * @since 2023-06-05 19:45:18
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserDao adminUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param adminUserId 主键
     * @return 实例对象
     */
    @Override
    public AdminUser queryById(Long adminUserId) {
        return this.adminUserDao.queryById(adminUserId);
    }

}
