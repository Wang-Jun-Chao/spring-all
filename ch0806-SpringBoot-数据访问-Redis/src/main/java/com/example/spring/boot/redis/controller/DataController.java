package com.example.spring.boot.redis.controller;

import com.example.spring.boot.redis.dao.PersonDao;
import com.example.spring.boot.redis.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 王俊超
 * Date: 2017-07-19 07:59
 * All Rights Reserved !!!
 */
@RestController
public class DataController {
    @Autowired
    PersonDao personDao;

    @RequestMapping("/set") //1
    public void set() {
        Person person = new Person("1", "wjc", 18);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    @RequestMapping("/getStr") //2
    public String getStr() {
        return personDao.getString();
    }

    @RequestMapping("/getPerson") //3
    public Person getPerson() {
        return personDao.getPerson();
    }
}
