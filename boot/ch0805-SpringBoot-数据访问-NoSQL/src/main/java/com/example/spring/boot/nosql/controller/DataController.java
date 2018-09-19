package com.example.spring.boot.nosql.controller;

import com.example.spring.boot.nosql.dao.PersonRepository;
import com.example.spring.boot.nosql.domain.Location;
import com.example.spring.boot.nosql.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2017-07-19 07:42
 * All Rights Reserved !!!
 */
@RestController
public class DataController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save() {
        Person p = new Person("wjc", 18);
        Collection<Location> locations = new LinkedHashSet<Location>();
        Location loc1 = new Location("长沙", "2009");
        Location loc2 = new Location("合肥", "2010");
        Location loc3 = new Location("广州", "2011");
        Location loc4 = new Location("深圳", "2012");
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        p.setLocations(locations);

        return personRepository.save(p);
    }

    @RequestMapping("/q1")
    public Person q1(String name) {
        return personRepository.findByName(name);
    }

    @RequestMapping("/q2")
    public List<Person> q2(Integer age) {
        return personRepository.withQueryFindByAge(age);
    }
}
