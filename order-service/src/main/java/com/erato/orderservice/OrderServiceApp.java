package com.erato.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */

@EnableFeignClients(basePackageClasses = {com.erato.cartservicefeign.CartServiceFeign.class, com.erato.goodsserviceapi.feign.GoodsServiceFeign.class})
@SpringBootApplication
public class OrderServiceApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderServiceApp.class, args);
    }
}
