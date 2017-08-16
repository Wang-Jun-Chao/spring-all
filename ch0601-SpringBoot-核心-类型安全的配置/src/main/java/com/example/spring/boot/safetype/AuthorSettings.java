package com.example.spring.boot.safetype;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 通过@ConfigurationProperties 加载properties 文件内的配置，通过prefix 属性指定
 * properties 的配置的前缀，
 * Author: 王俊超
 * Date: 2017-07-14 21:01
 * All Rights Reserved !!!
 */
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSettings {
    private String name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
