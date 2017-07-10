package com.example.spring.framework.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Author: 王俊超
 * Date: 2017-07-10 22:29
 * All Rights Reserved !!!
 */
@Configuration
@ComponentScan("com.example.spring.framework.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
