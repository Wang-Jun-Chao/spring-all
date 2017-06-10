package com.example.spring.boot.redis;

import com.example.spring.boot.redis.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collections;

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
        ctx.getBean("test", Test.class).cachePut(1, "2", Collections.emptyList());
        ctx.getBean("test", Test.class).cachePut2(1, "2", Collections.emptyList());
        ctx.getBean("test", Test.class).cachePut3(1, "2", Collections.emptyList());

        Person person = new Person(123L, "jack", 18, "china");

        ctx.getBean("test", Test.class).cachePut4(person);
        ctx.getBean("test", Test.class).cachePut5(person);
    }
}
