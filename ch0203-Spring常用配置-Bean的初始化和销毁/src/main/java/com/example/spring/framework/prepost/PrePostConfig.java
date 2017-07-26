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

    // initMethod 和destroyMethod 指定BeanWayService 类的init 和destroy
    // 方法在构造之后、Bean 销毁之前执行。
    @Bean(initMethod = "init", destroyMethod = "destroy")
    BeanWayService beanWayService() {
        return new BeanWayService();
    }

    @Bean
    JSR250WayService jsr250WayService() {
        return  new JSR250WayService();
    }
}
