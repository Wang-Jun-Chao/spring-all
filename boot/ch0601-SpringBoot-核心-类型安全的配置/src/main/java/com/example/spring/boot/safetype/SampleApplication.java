package com.example.spring.boot.safetype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 王俊超
 * Date: 2017-07-14 21:04
 * All Rights Reserved !!!
 */
@RestController
@SpringBootApplication
public class SampleApplication {
    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    public String index() {
        return "author name is " + authorSettings.getName()
                + " and author age is " + authorSettings.getAge();
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}
