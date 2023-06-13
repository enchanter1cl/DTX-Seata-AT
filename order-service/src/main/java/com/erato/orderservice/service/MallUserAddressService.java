package com.erato.orderservice.service;

import com.erato.orderservice.entity.MallUserAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 收货地址表(MallUserAddress)表服务接口
 *
 * @author makejava
 * @since 2023-06-12 16:28:40
 */
public interface MallUserAddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    MallUserAddress queryById(Long addressId);

    /**
     * 分页查询
     *
     * @param mallUserAddress 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<MallUserAddress> queryByPage(MallUserAddress mallUserAddress, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param mallUserAddress 实例对象
     * @return 实例对象
     */
    MallUserAddress insert(MallUserAddress mallUserAddress);

    /**
     * 修改数据
     *
     * @param mallUserAddress 实例对象
     * @return 实例对象
     */
    MallUserAddress update(MallUserAddress mallUserAddress);

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    boolean deleteById(Long addressId);

}
