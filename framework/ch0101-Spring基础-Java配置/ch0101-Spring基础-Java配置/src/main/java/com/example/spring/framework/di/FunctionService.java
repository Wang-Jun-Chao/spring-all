package com.example.spring.framework.di;

import org.springframework.stereotype.Service;

/**
 * 使用@Service 注解声明当前FunctionService 类是Spring 管理的一个Beano 其中，使
 * 用@Component 、@Service 、@Repository 和@Controller 是等效的，可根据需要选用。
 *
 * Author: 王俊超
 * Date: 2017-07-10 08:01
 * All Rights Reserved !!!
 */
@Service
public class FunctionService {
    public String sayHello(String word) {
        return "Hello " + word + " !";
    }

}
