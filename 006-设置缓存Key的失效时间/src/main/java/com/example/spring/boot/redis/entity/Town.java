package com.example.spring.boot.redis.entity;

/**
 * 镇
 * Author: 王俊超
 * Date: 2017-06-12 20:06
 * All Rights Reserved !!!
 */
public class Town {
    private long id;
    private String name;
    private City city;

    public Town() {
    }

    public Town(long id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public long getId() {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
