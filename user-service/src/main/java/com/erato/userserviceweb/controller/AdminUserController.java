package com.erato.userserviceweb.controller;

import com.erato.cloud.common.dto.Result;
import com.erato.cloud.common.dto.ResultGenerator;
import com.erato.userserviceweb.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * (AdminUser)表控制层
 *
 * @author makejava
 * @since 2023-06-05 19:45:17
 */
@RestController
//@RequestMapping("adminUser")
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    @GetMapping("/users/admin/admin-user/{id}")
    public Result queryAdminUserById(@PathVariable("id")Long id) {
        return ResultGenerator.genSuccessResult(adminUserService.queryById(id));
    }

}

