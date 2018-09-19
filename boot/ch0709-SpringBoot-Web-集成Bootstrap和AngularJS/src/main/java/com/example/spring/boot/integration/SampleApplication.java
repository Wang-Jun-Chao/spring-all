package com.example.spring.boot.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 王俊超
 * Date: 2017-07-17 20:13
 * All Rights Reserved !!!
 */
@RestController
@SpringBootApplication
public class SampleApplication {
    @RequestMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person search(String personName) {

        return new Person(personName, 32, "中国");

    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}
