package com.example.spring.framework.prepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: 王俊超
 * Date: 2017-07-11 07:22
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PrePostConfig.class);

        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService = context.getBean(JSR250WayService.class);

        context.close();
    }
}
