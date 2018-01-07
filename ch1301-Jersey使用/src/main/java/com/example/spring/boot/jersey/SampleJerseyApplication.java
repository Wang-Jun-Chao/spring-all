package com.example.spring.boot.jersey;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Author: 王俊超
 * Date: 2018-01-07 19-30
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
@SpringBootApplication
public class SampleJerseyApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        new SampleJerseyApplication()
                .configure(new SpringApplicationBuilder(SampleJerseyApplication.class))
                .run(args);
    }
}
