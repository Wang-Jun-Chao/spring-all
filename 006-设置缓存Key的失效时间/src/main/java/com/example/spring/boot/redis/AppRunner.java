package com.example.spring.boot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author: 王俊超
 * Date: 2017-05-07 10:04
 * All Rights Reserved !!!
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableAspectJAutoProxy
public class AppRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AppRunner.class, args);

    }
}
