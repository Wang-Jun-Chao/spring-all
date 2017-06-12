package com.example.spring.boot.redis.entity;

/**
 * 县
 * Author: 王俊超
 * Date: 2017-06-12 20:06
 * All Rights Reserved !!!
 */
public class City {
    private int id;
    private String name;
    private Province province;

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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
