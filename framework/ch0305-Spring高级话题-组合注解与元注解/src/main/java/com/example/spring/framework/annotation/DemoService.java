package com.example.spring.framework.annotation;

import org.springframework.stereotype.Service;

/**
 * Author: 王俊超
 * Date: 2017-07-11 08:19
 * All Rights Reserved !!!
 */
@Service
public class DemoService {
    public void outputResult(){
        System.out.println("从组合注解配置照样获得的bean");
    }
}
