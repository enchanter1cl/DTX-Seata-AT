package com.erato.userserviceweb.config;


import com.erato.userserviceweb.config.handler.TokenToAdminUserMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/*在WebMvcConfigurer中配置TokenToAdminUserMethodArgumentResolver使刚才自定义的resolver生效，*/
@Configuration
public class AdminUserWebConfigurer extends WebMvcConfigurationSupport
{
    @Autowired
    TokenToAdminUserMethodArgumentResolver tokenToAdminUserMethodArgumentResolver;

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(tokenToAdminUserMethodArgumentResolver);
    }
}
