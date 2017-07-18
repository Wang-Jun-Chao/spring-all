package com.example.spring.boot.service;

import com.example.spring.boot.domain.Person;

/**
 * Author: 王俊超
 * Date: 2017-07-18 08:15
 * All Rights Reserved !!!
 */
public interface DemoService {
    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);
}
