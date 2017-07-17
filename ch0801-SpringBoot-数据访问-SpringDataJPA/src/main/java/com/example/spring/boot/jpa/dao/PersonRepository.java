package com.example.spring.boot.jpa.dao;

import com.example.spring.boot.jpa.domain.Person;
import com.example.spring.boot.jpa.support.CustomRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Author: 王俊超
 * Date: 2017-07-17 20:56
 * All Rights Reserved !!!
 */
public interface PersonRepository extends CustomRepository<Person, Long> {
    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    Person withNameAndAddressNamedQuery(String name, String address);
}
