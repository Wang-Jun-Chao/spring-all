package com.example.spring.framework.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件发布类
 * ①注入ApplicationContext用来发布事件。
 * ②使用ApplicationContext的publishEvent方法来发布。
 * Author: 王俊超
 * Date: 2017-07-11 07:38
 * All Rights Reserved !!!
 */
@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg) {
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }
}
