package com.example.spring.boot.redis.entity;

/**
 * 省
 * Author: 王俊超
 * Date: 2017-06-12 20:06
 * All Rights Reserved !!!
 */
public class Province {
    private int id;
    private String name;
    private Country country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
