package com.example.spring.boot.redis;

import com.example.spring.boot.redis.annotation.RedisCacheEvict;
import com.example.spring.boot.redis.annotation.RedisCacheGet;
import com.example.spring.boot.redis.annotation.RedisCachePut;
import com.example.spring.boot.redis.entity.City;
import com.example.spring.boot.redis.entity.Country;
import com.example.spring.boot.redis.entity.Province;
import com.example.spring.boot.redis.entity.Town;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Author: 王俊超
 * Date: 2017-06-10 06:26
 * All Rights Reserved !!!
 */
@Component
public class TestData {

    public  final static Country COUNTRY = new Country(111111, "CHINA");
    public  final static Province PROVINCE = new Province(222222, "GuangZhou", COUNTRY);
    public  final static City CITY = new City(333333, "ShenZhen", PROVINCE);
    public  final static Town TOWN = new Town(444444, "Where", CITY);

    public final static String LOCATION = "location";

    @RedisCachePut(cacheName = LOCATION, key = "#town.city.province.country.id",
            expire = 60, timeUnit = TimeUnit.SECONDS)
    public Country createCountry(Town town) {
        return town.getCity().getProvince().getCountry();
    }

    @RedisCacheGet(cacheName = LOCATION, key = "#id", expire = 60, timeUnit = TimeUnit.SECONDS)
    public Country getCountry(long id) {
        return COUNTRY;
    }

    @RedisCacheEvict(cacheName = LOCATION, key = "#id")
    public void deleteCountry(long id) {
        // 清除缓存
    }
}
