package com.erato.cartservice.controller;

import com.erato.cartservice.dao.ShoppingCartItemDao;
import com.erato.cartservice.entity.ShoppingCartItem;
import com.erato.cartservice.service.ShoppingCartItemService;
import com.erato.cloud.common.dto.Result;
import com.erato.cloud.common.dto.ResultGenerator;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ShoppingCartItem)表控制层
 *
 * @author makejava
 * @since 2023-06-12 17:37:54
 */
@RestController
@RequestMapping("shop-cart")
@Slf4j
public class ShoppingCartItemController {
    /**
     * 服务对象
     */
    @Resource
    private ShoppingCartItemService shoppingCartItemService;

    @Autowired
    ShoppingCartItemDao shoppingCartItemDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @GetMapping("getGoodsId")
    public long getGoodsId(@RequestParam("cartId") long cartId) {

        log.info("Seata全局事务id=================>{}", RootContext.getXID());

        ShoppingCartItem cartItem = shoppingCartItemDao.queryById((long) cartId);
        if (cartItem == null) {
            return 0L;
        }
        return cartItem.getGoodsId();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteById(@PathVariable("id") Long id) {
        return ResultGenerator.genSuccessResult(this.shoppingCartItemService.deleteById(id));
    }




    /**
     * 分页查询
     *
     * @param shoppingCartItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ShoppingCartItem>> queryByPage(ShoppingCartItem shoppingCartItem, PageRequest pageRequest) {
        return ResponseEntity.ok(this.shoppingCartItemService.queryByPage(shoppingCartItem, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ShoppingCartItem> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.shoppingCartItemService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param shoppingCartItem 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ShoppingCartItem> add(ShoppingCartItem shoppingCartItem) {
        return ResponseEntity.ok(this.shoppingCartItemService.insert(shoppingCartItem));
    }

    /**
     * 编辑数据
     *
     * @param shoppingCartItem 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ShoppingCartItem> edit(ShoppingCartItem shoppingCartItem) {
        return ResponseEntity.ok(this.shoppingCartItemService.update(shoppingCartItem));
    }

}

