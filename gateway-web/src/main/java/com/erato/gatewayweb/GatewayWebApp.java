package com.erato.gatewayweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class GatewayWebApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(GatewayWebApp.class, args);

        System.out.println( "Hello World!" );
    }
}
