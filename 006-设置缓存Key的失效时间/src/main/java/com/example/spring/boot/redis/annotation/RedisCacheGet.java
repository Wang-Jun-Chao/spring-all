package com.example.spring.boot.redis.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * Author: 王俊超
 * Date: 2017-06-10 05:56
 * All Rights Reserved !!!
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RedisCacheGet {

    String cacheName() default "";

    String key() default "";
}
