package com.example.spring.boot.redis.controller.impl;

import com.example.spring.boot.redis.controller.RedisController;
import com.example.spring.boot.redis.entity.Person;
import com.example.spring.boot.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 王俊超
 * Date: 2017-05-07 09:57
 * All Rights Reserved !!!
 */
@RestController
public class RedisControllerImpl implements RedisController{

    @Autowired
    RedisService redisService;


    @RequestMapping("/put")
    public Person put(Person person) {
        return redisService.save(person);
    }


    @RequestMapping("/able")
    public Person cacheable(Person person) {
        return redisService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id) {
        redisService.remove(id);
        return "ok";
    }
}
