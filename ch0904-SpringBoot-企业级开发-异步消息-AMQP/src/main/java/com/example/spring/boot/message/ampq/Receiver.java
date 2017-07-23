package com.example.spring.boot.message.ampq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Author: 王俊超
 * Date: 2017-07-23 11:46
 * All Rights Reserved !!!
 */
@Component
public class Receiver {

    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }


}
