package com.example.spring.boot.cxf.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Author: 王俊超
 * Date: 2018-01-09 22-17
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */

@SpringBootApplication(scanBasePackages = "com.example.spring.boot.cxf.server")
public class ServerRunner {
    public static void main(String[] args) {
        SpringApplication.run(ServerRunner.class, args);
    }
}
