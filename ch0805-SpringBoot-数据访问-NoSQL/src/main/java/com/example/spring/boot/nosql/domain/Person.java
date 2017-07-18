package com.example.spring.boot.nosql.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Author: 王俊超
 * Date: 2017-07-19 07:37
 * All Rights Reserved !!!
 */
@Document //1
public class Person {
    @Id
    private String id;
    private String name;
    private Integer age;
    @Field("locs")
    private Collection<Location> locations =  new LinkedHashSet<Location>();


    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }
}
