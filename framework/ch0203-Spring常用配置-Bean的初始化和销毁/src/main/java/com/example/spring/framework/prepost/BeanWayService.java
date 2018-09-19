package com.example.spring.framework.prepost;

/**
 * Author: 王俊超
 * Date: 2017-07-11 07:18
 * All Rights Reserved !!!
 */
public class BeanWayService {
    public void init() {
        System.out.println("@Bean-init-method");
    }

    public BeanWayService() {
        System.out.println("初始化构造函数-BeanWayService");
    }

    public void destroy() {
        System.out.println("@Bean-destory-method");
    }
}
