package com.example.spring.framework.mvc.annotation.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Author: 王俊超
 * Date: 2017-07-11 22:19
 * All Rights Reserved !!!
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.example.spring.framework.mvc.annotation.web")
public class MyMvcConfig {
}
