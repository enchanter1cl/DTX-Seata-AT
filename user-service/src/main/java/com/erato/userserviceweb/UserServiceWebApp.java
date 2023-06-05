package com.erato.userserviceweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class UserServiceWebApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(UserServiceWebApp.class, args);

        System.out.println( "Hello World!" );
    }
}
