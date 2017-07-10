package com.example.spring.framework.javaconfig;

/**
 * Author: 王俊超
 * Date: 2017-07-10 08:03
 * All Rights Reserved !!!
 */
public class UseFunctionService {

    FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String SayHello(String word) {
        return functionService.sayHello(word);
    }

}
