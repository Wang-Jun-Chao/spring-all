package com.example.spring.boot.autoconfig.hello;

import com.example.spring.boot.autoconfig.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 王俊超
 * Date: 2017-07-14 21:35
 * All Rights Reserved !!!
 */
@RestController
@SpringBootApplication
public class SampleApplication {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/")
    public String index() {
        return helloService.sayHello();
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

}
