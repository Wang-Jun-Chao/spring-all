package com.example.spring.boot.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: 王俊超
 * Date: 2017-07-16 09:17
 * All Rights Reserved !!!
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
