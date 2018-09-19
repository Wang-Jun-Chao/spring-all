package com.example.spring.boot.dao;

import com.example.spring.boot.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: 王俊超
 * Date: 2017-07-18 08:13
 * All Rights Reserved !!!
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
