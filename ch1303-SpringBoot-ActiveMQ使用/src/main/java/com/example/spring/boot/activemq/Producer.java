package com.example.spring.boot.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * Author: 王俊超
 * Date: 2018-01-10 07:57
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */

@Component
public class Producer implements CommandLineRunner {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void run(String... strings) throws Exception {
        send("Sampme message");
        System.out.println("Message was sent to the Queue");
    }

    public void send(String message) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, message);
    }
}
