package com.example.spring.framework.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Author: 王俊超
 * Date: 2017-07-11 07:37
 * All Rights Reserved !!!
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("我(bean-demoListener)接受到了bean-demoPublisher发布的消息:" + msg);
        System.out.println("发生事件的对象是：" + event.getSource());
    }
}
