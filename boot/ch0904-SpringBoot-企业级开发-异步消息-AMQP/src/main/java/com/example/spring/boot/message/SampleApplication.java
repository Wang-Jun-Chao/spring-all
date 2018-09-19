package com.example.spring.boot.message;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Author: 王俊超
 * Date: 2017-07-23 11:47
 * All Rights Reserved !!!
 */
@SpringBootApplication
public class SampleApplication implements CommandLineRunner {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

    @Bean //2
    public Queue wiselyQueue() {
        return new Queue("my-queue");
    }


    @Override
    public void run(String... args) throws Exception {
        rabbitTemplate.convertAndSend("my-queue", "来自RabbitMQ的问候"); //3
    }
}
