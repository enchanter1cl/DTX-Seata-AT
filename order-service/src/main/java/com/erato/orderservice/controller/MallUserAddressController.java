package com.erato.orderservice.controller;

import com.erato.orderservice.entity.MallUserAddress;
import com.erato.orderservice.service.MallUserAddressService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 收货地址表(MallUserAddress)表控制层
 *
 * @author makejava
 * @since 2023-06-12 16:28:35
 */
@RestController
@RequestMapping("mallUserAddress")
public class MallUserAddressController {
    /**
     * 服务对象
     */
    @Resource
    private MallUserAddressService mallUserAddressService;

    /**
     * 分页查询
     *
     * @param mallUserAddress 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<MallUserAddress>> queryByPage(MallUserAddress mallUserAddress, PageRequest pageRequest) {
        return ResponseEntity.ok(this.mallUserAddressService.queryByPage(mallUserAddress, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<MallUserAddress> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.mallUserAddressService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param mallUserAddress 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<MallUserAddress> add(MallUserAddress mallUserAddress) {
        return ResponseEntity.ok(this.mallUserAddressService.insert(mallUserAddress));
    }

    /**
     * 编辑数据
     *
     * @param mallUserAddress 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<MallUserAddress> edit(MallUserAddress mallUserAddress) {
        return ResponseEntity.ok(this.mallUserAddressService.update(mallUserAddress));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.mallUserAddressService.deleteById(id));
    }

}

