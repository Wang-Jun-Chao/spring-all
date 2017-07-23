package com.example.spring.boot.microservice.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author: 王俊超
 * Date: 2017-07-23 17:07
 * All Rights Reserved !!!
 */
@SpringBootApplication
@EnableEurekaClient
public class PersonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonApplication.class, args);
    }
}
