package com.erato.userserviceweb.dao;

import com.erato.userserviceweb.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;


/**
 * (AdminUser)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-05 19:45:17
 */
@Mapper
public interface AdminUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param adminUserId 主键
     * @return 实例对象
     */
    AdminUser queryById(Long adminUserId);


}

