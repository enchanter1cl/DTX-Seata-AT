package com.erato.goodsservice.controller;

import com.erato.cloud.common.dto.Result;
import com.erato.cloud.common.dto.ResultGenerator;
import com.erato.cloud.common.pojo.AdminUserToken;
import com.erato.goodsservice.config.annotation.TokenToAdminUser;
import com.erato.goodsservice.entity.AdminUser;
import com.erato.goodsservice.req.AdminLoginParam;
import com.erato.goodsservice.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * (AdminUser)表控制层
 *
 * @author makejava
 * @since 2023-06-05 19:45:17
 */
@RestController
@Slf4j
//@RequestMapping("adminUser")
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    @RequestMapping(value = "/users/admin/login", method = RequestMethod.POST)
    public Result<String> login(@RequestBody AdminLoginParam adminLoginParam) {
        String loginResult = adminUserService.login(adminLoginParam.getUserName(), adminLoginParam.getPasswordMd5());
        log.info("manage login api,adminName={},loginResult={}", adminLoginParam.getUserName(), loginResult);

        //登录成功
        if (!StringUtils.isEmpty(loginResult) && loginResult.length() == 32) {
            Result result = ResultGenerator.genSuccessResult();
            result.setData(loginResult);
            return result;
        }
        //登录失败
        return ResultGenerator.genFailResult(loginResult);
    }



    @RequestMapping(value = "/users/admin/profile", method = RequestMethod.POST)
    public Result profile(@TokenToAdminUser AdminUserToken adminUser) {
        log.info("adminUser:{}", adminUser.toString());
        AdminUser adminUserEntity = adminUserService.getUserDetailById(adminUser.getAdminUserId());
        if (adminUserEntity != null) {
            adminUserEntity.setLoginPassword("******");
            Result result = ResultGenerator.genSuccessResult();
            result.setData(adminUserEntity);
            return result;
        }
        return ResultGenerator.genFailResult("无此用户数据");
    }

    @GetMapping("/users/admin/test")
    public String testGateway () {
        return "hello";
    }

    @GetMapping("/users/admin/admin-user/{id}")
    public Result queryAdminUserById(@PathVariable("id")Long id) {
        return ResultGenerator.genSuccessResult(adminUserService.queryById(id));
    }

}

