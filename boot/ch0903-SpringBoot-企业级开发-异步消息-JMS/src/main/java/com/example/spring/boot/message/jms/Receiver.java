package com.example.spring.boot.message.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Author: 王俊超
 * Date: 2017-07-23 10:57
 * All Rights Reserved !!!
 */
@Component
public class Receiver {
    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message) {
        System.out.println("接受到: <" + message + ">");
    }

}
