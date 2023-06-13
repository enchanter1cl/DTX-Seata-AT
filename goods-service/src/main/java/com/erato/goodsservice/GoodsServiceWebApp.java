package com.erato.goodsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@EnableFeignClients(basePackageClasses = {com.erato.userserviceweb.remote.AdminUserServiceFeign.class})
@SpringBootApplication
public class GoodsServiceWebApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(GoodsServiceWebApp.class, args);

        System.out.println( "Hello World!" );
    }
}
