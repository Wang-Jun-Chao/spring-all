package com.example.spring.boot.microservice.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Author: 王俊超
 * Date: 2017-07-23 17:27
 * All Rights Reserved !!!
 */
@Service
public class SomeHystrixService {

    @Autowired
    RestTemplate restTemplate; //1

    @HystrixCommand(fallbackMethod = "fallbackSome") //2
    public String getSome() {
        return restTemplate.getForObject("http://some/getsome", String.class);
    }

    public String fallbackSome() {
        return "some service模块故障";
    }
}
