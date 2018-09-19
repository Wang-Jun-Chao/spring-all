package com.example.spring.boot.nosql.domain;

/**
 * Author: 王俊超
 * Date: 2017-07-19 07:39
 * All Rights Reserved !!!
 */
public class Location {
    private String place;
    private String year;

    public Location(String place, String year) {
        super();
        this.place = place;
        this.year = year;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
