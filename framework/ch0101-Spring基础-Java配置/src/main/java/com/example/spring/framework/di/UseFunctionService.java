package com.example.spring.framework.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 使用@Service 注解声明当前UseFunctionService 类是Spring 管理的一个Bean
 * <p>
 * Author: 王俊超
 * Date: 2017-07-10 08:03
 * All Rights Reserved !!!
 */
@Service
public class UseFunctionService {

    /**
     * 使用@Autowired 将FunctionService 的实体Bean 注入到UseFunctionService 中，
     * 让UseFunctionService 具备FunctionService 的功能，此处使用JSR嗣330的@Inject
     * 注解或者JSR-250的@Resource 注解是等效的。
     */
    @Autowired
    FunctionService functionService;

    public String SayHello(String word) {
        return functionService.sayHello(word);
    }

}
