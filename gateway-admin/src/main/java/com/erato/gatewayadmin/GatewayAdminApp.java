package com.erato.gatewayadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class GatewayAdminApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(GatewayAdminApp.class, args);

        System.out.println( "Hello World!" );
    }
}
