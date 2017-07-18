package com.example.spring.boot.nosql.dao;

import com.example.spring.boot.nosql.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Author: 王俊超
 * Date: 2017-07-19 07:37
 * All Rights Reserved !!!
 */
public interface PersonRepository extends MongoRepository<Person, String>{
    Person findByName(String name);

    @Query("{'age': ?0}")
    List<Person> withQueryFindByAge(Integer age);
}
