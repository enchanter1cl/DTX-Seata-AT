package com.erato.goodsservice.dao;

import com.erato.cloud.common.pojo.AdminUserToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserTokenMapper {

    int deleteById(Long userId);

    int insert(AdminUserToken record);

    //int insertSelective(AdminUserToken record);

    AdminUserToken queryById(Long userId);

    AdminUserToken selectByToken(String token);

    //int updateByPrimaryKeySelective(AdminUserToken record);

    int update(AdminUserToken record);
}
