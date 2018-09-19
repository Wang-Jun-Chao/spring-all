package com.example.spring.framework.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: 王俊超
 * Date: 2017-07-11 07:26
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        activeProfiles("dev");
        activeProfiles("prod");

    }

    /**
     * ①先将活动的Profile 设置为参数传的值
     * ②后直注册Bean 配置类，不然会报Bean 未定义的错误。
     * ③刷新容器。
     *
     * @param profiles
     */
    private static void activeProfiles(String... profiles) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles(profiles); //1
        context.register(ProfileConfig.class);//2
        context.refresh(); //3

        DemoBean demoBean = context.getBean(DemoBean.class);

        System.out.println(demoBean.getContent());

        context.close();
    }
}
