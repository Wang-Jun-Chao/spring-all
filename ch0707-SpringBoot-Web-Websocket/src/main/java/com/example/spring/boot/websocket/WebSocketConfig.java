package com.example.spring.boot.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 通过@EnableWebSocketMessageBroker 注解开启使用STOMP 协议来传输基于代理message broker ）的消息，
 * 这时控制器支持使用@MessageMapping ，就像使用@RequestMapping一样。
 * Author: 王俊超
 * Date: 2017-07-17 07:32
 * All Rights Reserved !!!
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /**
     * 注册STOMP 协议的节点（ endpoint ），并映射的指定的URL
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 泣册一个STOMP 的endpoint ，并指定使用SockJS 协议
        registry.addEndpoint("/endpointWisely").withSockJS();
    }

    /**
     * 配置 消息代理（ Message Broker ）。
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // t·:r苗式应配捏一个／topic 消息代现。
        registry.enableSimpleBroker("/topic");
    }
}
