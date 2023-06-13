package com.erato.goodsservice.controller;


import com.erato.cloud.common.dto.Result;
import com.erato.cloud.common.dto.ResultGenerator;
import com.erato.cloud.common.util.BeanUtil;
import com.erato.goodsservice.config.annotation.TokenToAdminUser;
import com.erato.goodsservice.entity.GoodsCategory;
import com.erato.goodsservice.entity.LoginAdminUser;
import com.erato.goodsservice.req.GoodsCategoryEditReq;
import com.erato.goodsservice.service.GoodsCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories/admin")
@Slf4j
public class GoodsCategoryController {

    @Autowired
    GoodsCategoryService goodsCategoryService;

    /**
     * 测试 feign 调用用户中心
     * @param loginAdminUser
     * @return
     */
    @GetMapping("/testLoginAdminUser")
    public Result testAdminUser(@TokenToAdminUser LoginAdminUser loginAdminUser) {
        log.info("loginAdminUser:{}", loginAdminUser);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody GoodsCategoryEditReq goodsCategoryEditParam, @TokenToAdminUser LoginAdminUser adminUser) {

        log.info("adminUser: {}", adminUser);

        GoodsCategory goodsCategory = new GoodsCategory();
        BeanUtil.copyProperties(goodsCategoryEditParam, goodsCategory);
        log.info("goodsCategory: {}", goodsCategory);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail/{id}")
    public Result info(@PathVariable("id")Long id, LoginAdminUser loginAdminUser) {
        log.info("adminUser: {}", loginAdminUser);
        GoodsCategory goodsCategory = goodsCategoryService.queryById(id);
        if (goodsCategory == null) {
            return ResultGenerator.genFailResult("未查到");
        }
        return ResultGenerator.genSuccessResult(goodsCategory);
    }
}
