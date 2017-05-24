package com.example.spring.boot.configuration.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 王俊超
 * Date: 2017-05-24 20:47
 * All Rights Reserved !!!
 */
@RestController
public class WebService {
    @Value("${active}")
    private String env;

    @RequestMapping(value = "env")
    public String getEnv() {
        return  env;
    }
}
