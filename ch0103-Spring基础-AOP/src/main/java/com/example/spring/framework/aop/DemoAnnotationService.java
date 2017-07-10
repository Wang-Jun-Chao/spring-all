package com.example.spring.framework.aop;

import org.springframework.stereotype.Service;

/**
 * Author: 王俊超
 * Date: 2017-07-10 22:27
 * All Rights Reserved !!!
 */
@Service
public class DemoAnnotationService {

    @Action(name = "注解式拦截的add操作")
    public void add(){}
}
