package com.erato.userserviceweb.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (MallUser)实体类
 *
 * @author makejava
 * @since 2023-06-12 15:05:05
 */
public class MallUser implements Serializable {
    private static final long serialVersionUID = -84973817329617643L;
    /**
     * 用户主键id
     */
    private Long userId;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 登陆名称(默认为手机号)
     */
    private String loginName;
    /**
     * MD5加密后的密码
     */
    private String passwordMd5;
    /**
     * 个性签名
     */
    private String introduceSign;
    /**
     * 注销标识字段(0-正常 1-已注销)
     */
    private Integer isDeleted;
    /**
     * 锁定标识字段(0-未锁定 1-已锁定)
     */
    private Integer lockedFlag;
    /**
     * 注册时间
     */
    private Date createTime;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public void setPasswordMd5(String passwordMd5) {
        this.passwordMd5 = passwordMd5;
    }

    public String getIntroduceSign() {
        return introduceSign;
    }

    public void setIntroduceSign(String introduceSign) {
        this.introduceSign = introduceSign;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getLockedFlag() {
        return lockedFlag;
    }

    public void setLockedFlag(Integer lockedFlag) {
        this.lockedFlag = lockedFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

