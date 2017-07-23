package com.example.spring.boot.microservice.person.controller;

import com.example.spring.boot.microservice.person.dao.PersonRepository;
import com.example.spring.boot.microservice.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: 王俊超
 * Date: 2017-07-23 17:08
 * All Rights Reserved !!!
 */
@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<Person> savePerson(@RequestBody String personName) {
        Person p = new Person(personName);
        personRepository.save(p);
        List<Person> people = personRepository.findAll(new PageRequest(0, 10)).getContent();
        return people;
    }


}
