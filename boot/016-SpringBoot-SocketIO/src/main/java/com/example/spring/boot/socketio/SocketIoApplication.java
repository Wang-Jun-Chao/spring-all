package com.example.spring.boot.socketio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-28 13:18
 **/
@SpringBootApplication
public class SocketIoApplication {
    private final static Logger logger = LoggerFactory.getLogger(SocketIoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SocketIoApplication.class, args);
    }
}
