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
public @interface RedisCachePut {

    /**
     * 缓存名称
     *
     * @return
     */
    String cacheName();

    /**
     * 缓存key
     *
     * @return
     */
    String key();

    /**
     * 缓存过期时间
     *
     * @return
     */
    int expire() default 0;

    /**
     * 缓存的时间单位
     *
     * @return
     */
    TimeUnit timeUnit();
}
