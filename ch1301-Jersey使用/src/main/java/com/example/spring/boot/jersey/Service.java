package com.example.spring.boot.jersey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Author: 王俊超
 * Date: 2018-01-07 19-24
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
@Component
public class Service {

    @Value("${message:World}")
    private String msg;

    public String message() {
        return this.msg;
    }
}
