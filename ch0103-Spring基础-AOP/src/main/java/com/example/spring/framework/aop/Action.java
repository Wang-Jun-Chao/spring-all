package com.example.spring.framework.aop;

import java.lang.annotation.*;

/**
 * Author: 王俊超
 * Date: 2017-07-10 22:26
 * All Rights Reserved !!!
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
