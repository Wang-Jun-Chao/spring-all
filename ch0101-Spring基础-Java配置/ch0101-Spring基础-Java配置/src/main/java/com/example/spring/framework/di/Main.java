package com.example.spring.framework.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1、使用AnnotationConfigApplicationContext 作为Spring 容器，接受输入一个配置类作为参数；
 * 2、获得声明自己置的UseFunctionService 的Bean
 *
 * Author: 王俊超
 * Date: 2017-07-10 08:08
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DiConfig.class); // 1

        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class); //2

        System.out.println(useFunctionService.SayHello("world"));

        context.close();
    }
}
