package com.example.spring.boot.redis.controller;

import com.example.spring.boot.redis.entity.Person;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: 王俊超
 * Date: 2017-05-07 09:57
 * All Rights Reserved !!!
 */
public interface RedisController {
    @RequestMapping("/put")
    public Person put(Person person);

    @RequestMapping("/able")
    public Person cacheable(Person person);

    @RequestMapping("/evit")
    public String evit(Long id);
}
