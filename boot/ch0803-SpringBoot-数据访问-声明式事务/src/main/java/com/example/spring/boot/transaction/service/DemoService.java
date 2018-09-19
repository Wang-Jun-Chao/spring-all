package com.example.spring.boot.transaction.service;

import com.example.spring.boot.transaction.domain.Person;

/**
 * Author: 王俊超
 * Date: 2017-07-18 07:57
 * All Rights Reserved !!!
 */
public interface DemoService {
    Person savePersonWithRollBack(Person person);
    Person savePersonWithoutRollBack(Person person);
}
