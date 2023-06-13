package com.erato.goodsservice.service;

import com.erato.goodsservice.entity.AdminUser;

/**
 * (AdminUser)表服务接口
 *
 * @author makejava
 * @since 2023-06-05 19:45:18
 */
public interface AdminUserService {

    public String login(String userName, String password);

    public AdminUser getUserDetailById(Long loginUserId);

    /**
     * 通过ID查询单条数据
     *
     * @param adminUserId 主键
     * @return 实例对象
     */
    AdminUser queryById(Long adminUserId);

}
