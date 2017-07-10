package com.example.spring.framework.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: 王俊超
 * Date: 2017-07-10 08:21
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class);

        // 获取第一个bean
        UseFunctionService useFunctionService = context.getBean("useFunctionService",
                UseFunctionService.class);
        System.out.println(useFunctionService.SayHello("java config"));

        // 获取第二个bean
        UseFunctionService useFunctionService2 = context.getBean("useFunctionService2",
                UseFunctionService.class);
        System.out.println(useFunctionService2.SayHello("java config2"));

        context.close();

    }
}
