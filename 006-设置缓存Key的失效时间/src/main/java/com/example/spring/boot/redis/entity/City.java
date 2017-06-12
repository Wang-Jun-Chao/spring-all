package com.example.spring.boot.redis.entity;

/**
 * 县
 * Author: 王俊超
 * Date: 2017-06-12 20:06
 * All Rights Reserved !!!
 */
public class City {
    private long id;
    private String name;
    private Province province;

    public City() {
    }

    public City(long id, String name, Province province) {
        this.id = id;
        this.name = name;
        this.province = province;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
