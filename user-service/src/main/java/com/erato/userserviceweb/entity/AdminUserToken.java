package com.erato.userserviceweb.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (AdminUserToken)实体类
 *
 * @author makejava
 * @since 2023-06-05 20:51:48
 */
@Data
public class AdminUserToken implements Serializable {
    private static final long serialVersionUID = -63901341241985554L;
    /**
     * 用户主键id
     */
    private Long adminUserId;
    /**
     * token值(32位字符串)
     */
    private String token;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * token过期时间
     */
    private LocalDateTime expireTime;


    public Long getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Long adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getToken() {
        return token;
    }



}

