package com.example.spring.boot.redis.controller.impl;

import com.example.spring.boot.redis.common.RedisClient;
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
public class RedisControllerImpl implements RedisController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisClient redisClient;

    // 下面三个方法是redis自动管的
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

    @Override
    public String renew(Person person) {
        redisService.update(person);
        return "ok";
    }


    // 下面的方法是手工操作的
    @RequestMapping("/update/manual")
    @Override
    public Person update(Long id) {
        Person person = redisClient.getObject(id);
        person.setAddress("" + Math.random());
        redisClient.set(id, person);
        return person;
    }

    @RequestMapping("/get/manual")
    @Override
    public Person get(Long id) {
        return redisClient.getObject(id);
    }

    @RequestMapping("/set/manual")
    @Override
    public Person set() {
        Person person = new Person();
        person.setId(666L);
        person.setName("name");
        person.setAge(16);
        person.setAddress("somewhere i do not know");
        redisClient.set(person.getId(), person);
        return person;
    }
    @RequestMapping("/delete/manual")
    @Override
    public String delete(Long id) {
        redisClient.delete(id);
        return "ok";
    }

}
