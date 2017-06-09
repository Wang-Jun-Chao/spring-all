package com.example.spring.boot.redis.service;

import com.example.spring.boot.redis.entity.Person;

/**
 * Author: 王俊超
 * Date: 2017-05-07 09:57
 * All Rights Reserved !!!
 */
public interface RedisService {
    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);

    void update(Person person);
}
