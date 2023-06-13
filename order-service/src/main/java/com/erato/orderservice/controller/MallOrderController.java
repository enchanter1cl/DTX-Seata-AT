package com.erato.orderservice.controller;

import com.erato.orderservice.entity.MallOrder;
import com.erato.orderservice.service.MallOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * (MallOrder)表控制层
 *
 * @author makejava
 * @since 2023-06-12 16:29:42
 */
@RestController
@RequestMapping("order")
public class MallOrderController {
    /**
     * 服务对象
     */
    @Resource
    private MallOrderService mallOrderService;

    @GetMapping("/saveOrder")
    public Boolean saveOrder(@RequestParam("cartId") int cartId) {
        return mallOrderService.saveOrder(cartId);
    }

    /**
     * 分页查询
     *
     * @param mallOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<MallOrder>> queryByPage(MallOrder mallOrder, PageRequest pageRequest) {
        return ResponseEntity.ok(this.mallOrderService.queryByPage(mallOrder, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<MallOrder> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.mallOrderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param mallOrder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<MallOrder> add(MallOrder mallOrder) {
        return ResponseEntity.ok(this.mallOrderService.insert(mallOrder));
    }

    /**
     * 编辑数据
     *
     * @param mallOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<MallOrder> edit(MallOrder mallOrder) {
        return ResponseEntity.ok(this.mallOrderService.update(mallOrder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.mallOrderService.deleteById(id));
    }

}

