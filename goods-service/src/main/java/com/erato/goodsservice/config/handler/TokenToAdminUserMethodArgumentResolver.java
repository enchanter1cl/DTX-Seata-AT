package com.erato.goodsservice.config.handler;

import com.erato.cloud.common.dto.Result;
import com.erato.cloud.common.exception.NewBeeMallException;
import com.erato.goodsservice.config.annotation.TokenToAdminUser;
import com.erato.goodsservice.entity.LoginAdminUser;
import com.erato.userserviceweb.remote.AdminUserServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.LinkedHashMap;

@Component
@Slf4j
public class TokenToAdminUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    AdminUserServiceFeign adminUserServiceFeign;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(TokenToAdminUser.class)){
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        if (parameter.getParameterAnnotation(TokenToAdminUser.class) instanceof TokenToAdminUser) {
            String token = webRequest.getHeader("token");
            if (null != token && !"".equals(token)) {

                //通过用户中心获取用户信息
                Result result = adminUserServiceFeign.getAdminUserByToken(token);
                if (result == null || result.getResultCode() != 200 || result.getData() == null) {

                    NewBeeMallException.fail("Feign 请求获取用户失败");
                }

                LinkedHashMap dataMap = (LinkedHashMap)result.getData();
                System.out.println("---------------"+dataMap.get("loginUserName"));

                LoginAdminUser loginAdminUser = new LoginAdminUser();
                loginAdminUser.setAdminUserId(Long.valueOf(dataMap.get("adminUserId").toString()));
                loginAdminUser.setLoginUserName((String)dataMap.get("loginUserName"));
                loginAdminUser.setNickName((String)dataMap.get("nickName"));
                loginAdminUser.setLocked(Byte.valueOf(dataMap.get("locked").toString()));
                return loginAdminUser;

            } else {
                NewBeeMallException.fail("header 里没有 token");
            }

        }
        return null;
    }
}
