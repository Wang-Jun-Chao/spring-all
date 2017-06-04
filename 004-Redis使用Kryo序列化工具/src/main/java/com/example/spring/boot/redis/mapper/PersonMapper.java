package com.example.spring.boot.redis.mapper;


import com.example.spring.boot.redis.entity.Person;

public interface PersonMapper {

    long save(Person person);

    Person findOne(Long id);

    int delete(Long id);

    int update(Person person);
}
