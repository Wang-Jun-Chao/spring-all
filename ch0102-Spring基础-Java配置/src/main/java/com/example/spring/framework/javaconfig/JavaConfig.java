package com.example.spring.framework.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1、@Configuration 声明当前类是一个配置类
 * 2、@Bean将方法的返回值当作一个bean，bean的名称就是返回值的名称
 * 3、使用手动注入
 * 4、使用容器自动注入
 *
 * Author: 王俊超
 * Date: 2017-07-10 08:20
 * All Rights Reserved !!!
 */

@Configuration // 1
public class JavaConfig {
    @Bean // 2
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService() {
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService()); // 3
        return useFunctionService;
    }

    @Bean
    public UseFunctionService useFunctionService2(FunctionService functionService) {// 4
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService);
        return useFunctionService;
    }
}
