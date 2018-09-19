package com.example.spring.boot.transaction.service.impl;

import com.example.spring.boot.transaction.dao.PersonRepository;
import com.example.spring.boot.transaction.domain.Person;
import com.example.spring.boot.transaction.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: 王俊超
 * Date: 2017-07-18 07:57
 * All Rights Reserved !!!
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);

        if (person.getName().equals("王俊超")) {
            throw new IllegalArgumentException("王俊超已存在，数据将回滚"); //3
        }
        return p;
    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class}) //4
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);

        if (person.getName().equals("王俊超")) {
            throw new IllegalArgumentException("王俊超虽已存在，数据将不会回滚");
        }
        return p;
    }
}
