package com.example.spring.boot.microservice.ui.service;

import com.example.spring.boot.microservice.ui.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2017-07-23 17:29
 * All Rights Reserved !!!
 */
@Service
public class PersonHystrixService implements PersonService {

    @Autowired
    PersonService personService;

    @HystrixCommand(fallbackMethod = "fallbackSave") //1
    public List<Person> save(String name) {
        return personService.save(name);
    }

    public List<Person> fallbackSave(String name) {
        List<Person> list = new ArrayList<>();
        Person p = new Person(name + "没有保存成功，Person Service 故障");
        list.add(p);
        return list;
    }
}
