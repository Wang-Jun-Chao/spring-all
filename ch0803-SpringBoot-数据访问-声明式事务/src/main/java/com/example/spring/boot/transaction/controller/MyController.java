package com.example.spring.boot.transaction.controller;

import com.example.spring.boot.transaction.domain.Person;
import com.example.spring.boot.transaction.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 王俊超
 * Date: 2017-07-18 08:00
 * All Rights Reserved !!!
 */
@RestController
public class MyController {
    @Autowired
    DemoService demoService;

    @RequestMapping("/rollback")
    public Person rollback(Person person) { //1
        return demoService.savePersonWithRollBack(person);
    }

    @RequestMapping("/norollback")
    public Person noRollback(Person person) {//2
        return demoService.savePersonWithoutRollBack(person);
    }
}
