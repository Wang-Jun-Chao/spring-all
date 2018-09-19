package com.example.spring.boot.microservice.ui.controller;

import com.example.spring.boot.microservice.ui.domain.Person;
import com.example.spring.boot.microservice.ui.service.PersonHystrixService;
import com.example.spring.boot.microservice.ui.service.SomeHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: 王俊超
 * Date: 2017-07-23 17:26
 * All Rights Reserved !!!
 */
@RestController
public class UiController {
    @Autowired
    private SomeHystrixService someHystrixService;

    @Autowired
    private PersonHystrixService personHystrixService;

    @RequestMapping("/dispatch")
    public List<Person> sendMessage(@RequestBody String personName) {
        return personHystrixService.save(personName);
    }

    @RequestMapping(value = "/getsome",produces={MediaType.TEXT_PLAIN_VALUE})
    public String getSome(){
        return someHystrixService.getSome();
    }
}