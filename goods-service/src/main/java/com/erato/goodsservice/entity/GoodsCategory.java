package com.erato.goodsservice.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (GoodsCategory)实体类
 *
 * @author makejava
 * @since 2023-06-08 22:42:29
 */

@Data
public class GoodsCategory implements Serializable {
    private static final long serialVersionUID = -56064144027826000L;
    /**
     * 分类id
     */
    private Long categoryId;
    /**
     * 分类级别(1-一级分类 2-二级分类 3-三级分类)
     */
    private Byte categoryLevel;
    /**
     * 父分类id
     */
    private Long parentId;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 排序值(字段越大越靠前)
     */
    private Integer categoryRank;
    /**
     * 删除标识字段(0-未删除 1-已删除)
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建者id
     */
    private Integer createUser;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 修改者id
     */
    private Integer updateUser;


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryRank() {
        return categoryRank;
    }

    public void setCategoryRank(Integer categoryRank) {
        this.categoryRank = categoryRank;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

}

