package com.example.spring.boot.microservice.person.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Author: 王俊超
 * Date: 2017-07-23 17:09
 * All Rights Reserved !!!
 */
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Person() {
        super();
    }

    public Person(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
