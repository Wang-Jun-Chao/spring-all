package com.example.spring.boot.redis;

import com.example.spring.boot.redis.annotation.RedisCachePut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Author: 王俊超
 * Date: 2017-06-10 06:26
 * All Rights Reserved !!!
 */
@Component
public class Test {

    @RedisCachePut(cacheName = "cacheName", key = "key", expire = 0, timeUnit = TimeUnit.MINUTES)
    public Object cachePut() {
        return "Hello World";
    }
}
