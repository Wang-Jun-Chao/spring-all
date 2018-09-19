package com.example.spring.boot.undertow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 王俊超
 * Date: 2017-07-16 20:05
 * All Rights Reserved !!!
 */
@RestController
@SpringBootApplication
public class SampleApplication {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world from Undertow!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}
