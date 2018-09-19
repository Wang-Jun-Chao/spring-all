package com.example.spring.boot.transaction.dao;

import com.example.spring.boot.transaction.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: 王俊超
 * Date: 2017-07-18 07:56
 * All Rights Reserved !!!
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
