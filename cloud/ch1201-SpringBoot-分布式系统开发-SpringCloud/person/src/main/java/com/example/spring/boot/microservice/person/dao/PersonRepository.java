package com.example.spring.boot.microservice.person.dao;

import com.example.spring.boot.microservice.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: 王俊超
 * Date: 2017-07-23 17:09
 * All Rights Reserved !!!
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
