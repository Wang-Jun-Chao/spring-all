package com.example.spring.framework.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: 王俊超
 * Date: 2017-07-10 22:22
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();
        context.close();
    }
}
