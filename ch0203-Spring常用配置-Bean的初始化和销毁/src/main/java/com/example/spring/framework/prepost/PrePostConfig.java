package com.example.spring.framework.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Author: 王俊超
 * Date: 2017-07-11 07:19
 * All Rights Reserved !!!
 */
@Configuration
@ComponentScan("com.example.spring.framework.prepost")
public class PrePostConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    BeanWayService beanWayService() {
        return new BeanWayService();
    }

    @Bean
    JSR250WayService jsr250WayService() {
        return  new JSR250WayService();
    }
}
