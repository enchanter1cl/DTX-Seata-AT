package com.erato.orderservice.service.impl;

import com.erato.orderservice.entity.MallUserAddress;
import com.erato.orderservice.dao.MallUserAddressDao;
import com.erato.orderservice.service.MallUserAddressService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 收货地址表(MallUserAddress)表服务实现类
 *
 * @author makejava
 * @since 2023-06-12 16:28:41
 */
@Service("mallUserAddressService")
public class MallUserAddressServiceImpl implements MallUserAddressService {
    @Resource
    private MallUserAddressDao mallUserAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    @Override
    public MallUserAddress queryById(Long addressId) {
        return this.mallUserAddressDao.queryById(addressId);
    }

    /**
     * 分页查询
     *
     * @param mallUserAddress 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<MallUserAddress> queryByPage(MallUserAddress mallUserAddress, PageRequest pageRequest) {
        long total = this.mallUserAddressDao.count(mallUserAddress);
        return new PageImpl<>(this.mallUserAddressDao.queryAllByLimit(mallUserAddress, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param mallUserAddress 实例对象
     * @return 实例对象
     */
    @Override
    public MallUserAddress insert(MallUserAddress mallUserAddress) {
        this.mallUserAddressDao.insert(mallUserAddress);
        return mallUserAddress;
    }

    /**
     * 修改数据
     *
     * @param mallUserAddress 实例对象
     * @return 实例对象
     */
    @Override
    public MallUserAddress update(MallUserAddress mallUserAddress) {
        this.mallUserAddressDao.update(mallUserAddress);
        return this.queryById(mallUserAddress.getAddressId());
    }

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long addressId) {
        return this.mallUserAddressDao.deleteById(addressId) > 0;
    }
}
