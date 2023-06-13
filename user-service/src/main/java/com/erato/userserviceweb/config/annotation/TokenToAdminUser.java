package com.erato.goodsservice.config.annotation;


import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenToAdminUser {

    /**
     * 当前用户在 request 中的名字
     * @return
     */
    String value() default "adminUser";
}
