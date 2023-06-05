package com.erato.userserviceweb.service.impl;


import com.erato.userserviceweb.dao.AdminUserTokenMapper;
import com.erato.userserviceweb.service.AdminUserTokenService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * (AdminUserToken)表服务实现类
 *
 * @author makejava
 * @since 2023-06-05 20:51:49
 */
@Service("adminUserTokenService")
public class AdminUserTokenServiceImpl implements AdminUserTokenService {
    @Resource
    private AdminUserTokenMapper adminUserTokenMapper;

//    /**
//     * 通过ID查询单条数据
//     *
//     * @param adminUserId 主键
//     * @return 实例对象
//     */
//    @Override
//    public AdminUserToken queryById(Long adminUserId) {
//        return this.adminUserTokenDao.queryById(adminUserId);
//    }
//
//    /**
//     * 分页查询
//     *
//     * @param adminUserToken 筛选条件
//     * @param pageRequest    分页对象
//     * @return 查询结果
//     */
//    @Override
//    public Page<AdminUserToken> queryByPage(AdminUserToken adminUserToken, PageRequest pageRequest) {
//        long total = this.adminUserTokenDao.count(adminUserToken);
//        return new PageImpl<>(this.adminUserTokenDao.queryAllByLimit(adminUserToken, pageRequest), pageRequest, total);
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param adminUserToken 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public AdminUserToken insert(AdminUserToken adminUserToken) {
//        this.adminUserTokenDao.insert(adminUserToken);
//        return adminUserToken;
//    }
//
//    /**
//     * 修改数据
//     *
//     * @param adminUserToken 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public AdminUserToken update(AdminUserToken adminUserToken) {
//        this.adminUserTokenDao.update(adminUserToken);
//        return this.queryById(adminUserToken.getAdminUserId());
//    }
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param adminUserId 主键
//     * @return 是否成功
//     */
//    @Override
//    public boolean deleteById(Long adminUserId) {
//        return this.adminUserTokenDao.deleteById(adminUserId) > 0;
//    }
}
