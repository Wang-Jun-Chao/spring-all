package com.example.spring.boot.redis;

import com.example.spring.boot.redis.annotation.RedisCachePut;
import com.example.spring.boot.redis.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Author: 王俊超
 * Date: 2017-06-10 06:26
 * All Rights Reserved !!!
 */
@Component
public class Test {

    @RedisCachePut(cacheName = "cacheName", key = "key", expire = 0, timeUnit = TimeUnit.MINUTES)
    public Object cachePut(int a, String b, List<String> list) {
        return "Hello World";
    }

    @RedisCachePut(cacheName = "cacheName", key = "#a", expire = 0, timeUnit = TimeUnit.MINUTES)
    public Object cachePut2(int a, String b, List<String> list) {
        return "Hello World";
    }

    @RedisCachePut(cacheName = "cacheName", key = "#b", expire = 0, timeUnit = TimeUnit.MINUTES)
    public Object cachePut3(int a, String b, List<String> list) {
        return "Hello World";
    }

    @RedisCachePut(cacheName = "cacheName", key = "#person.id", expire = 0, timeUnit = TimeUnit.MINUTES)
    public Object cachePut3(Person person) {
        return "Hello World";
    }

    @RedisCachePut(cacheName = "cacheName", key = "#person.name", expire = 0, timeUnit = TimeUnit.MINUTES)
    public Object cachePut4(Person person) {
        return "Hello World";
    }

    @RedisCachePut(cacheName = "cacheName", key = "#person.address", expire = 0, timeUnit = TimeUnit.MINUTES)
    public Object cachePut5(Person person) {
        return "Hello World";
    }
}
