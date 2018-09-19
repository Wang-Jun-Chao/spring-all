package com.example.spring.boot.message;

import com.example.spring.boot.message.jms.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

/**
 * Author: 王俊超
 * Date: 2017-07-23 11:14
 * All Rights Reserved !!!
 */
@SpringBootApplication
public class SampleApplication implements CommandLineRunner {
    @Autowired
    JmsTemplate jmsTemplate; //2

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        jmsTemplate.send("my-destination", new Msg()); //3

    }
}
