package com.example.spring.boot.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * Author: 王俊超
 * Date: 2018-01-10 08:03
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
@EnableJms
@SpringBootApplication
public class SampleActiveMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleActiveMQApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }

}
