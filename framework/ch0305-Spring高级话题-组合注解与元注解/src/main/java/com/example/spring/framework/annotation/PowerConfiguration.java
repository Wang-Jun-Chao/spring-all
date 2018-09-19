package com.example.spring.framework.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * Author: 王俊超
 * Date: 2017-07-11 08:19
 * All Rights Reserved !!!
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration //1
@ComponentScan //2
public @interface PowerConfiguration {
    String[] value() default {};
}
