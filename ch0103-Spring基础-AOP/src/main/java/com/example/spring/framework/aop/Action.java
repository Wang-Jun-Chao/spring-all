package com.example.spring.framework.aop;

import java.lang.annotation.*;

/**
 * 注解本身是没有功能的，就和xml 一样。注解和xml都是一种元数据（解释数据的数据），
 * 注解的功能来自用这个注解的地方。
 * ElementType.METHOD：说明此注解使用在方法上
 * RetentionPolicy.RUNTIME：在运行期保留
 * Documented：可用于生成java文档
 *
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
