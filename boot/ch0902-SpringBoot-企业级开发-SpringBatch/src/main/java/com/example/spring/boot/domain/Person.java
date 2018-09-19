package com.example.spring.boot.domain;

import javax.validation.constraints.Size;

/**
 * Author: 王俊超
 * Date: 2017-07-20 07:44
 * All Rights Reserved !!!
 */
public class Person {
    @Size(max = 4, min = 2) //1
    private String name;

    private int age;

    private String nation;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
