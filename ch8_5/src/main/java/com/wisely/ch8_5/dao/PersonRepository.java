package com.wisely.ch8_5.dao;

import com.wisely.ch8_5.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
