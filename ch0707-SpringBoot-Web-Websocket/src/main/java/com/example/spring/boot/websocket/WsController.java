package com.example.spring.boot.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Author: 王俊超
 * Date: 2017-07-17 07:36
 * All Rights Reserved !!!
 */
@Controller
public class WsController {
    // ①当浏览器向服务端发送请求时，通过@MessageMapping 映射/welcome 这个地址，
    // 类似于@RequestMapping
    @MessageMapping("/welcome")
    // 当服务端有消息时，会对订阅了@SendTo 中的路径的浏览器发送消息。
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome, " +  message.getName());
    }
}
