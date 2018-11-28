package com.example.spring.boot.socketio;

import com.corundumstudio.socketio.SocketIOServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 应用启动完成后调用操作
 *
 * @Author: wangjunchao(王俊超)
 * @Time: 2018-08-17 10:19
 **/
@Component
public class SocketIoRunner implements ApplicationRunner, ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(SocketIoRunner.class);


    @Autowired
    private SocketIOServer server;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        server.start();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }
}
