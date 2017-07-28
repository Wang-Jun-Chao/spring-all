package com.example.spring.framework.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 * 实现ApplicationListener 接口，并指定监听的事件类型。
 * Author: 王俊超
 * Date: 2017-07-11 07:37
 * All Rights Reserved !!!
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    /**
     * 使用onApplicationEvent 方法对消息进行接受处理。
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("我(bean-demoListener)接受到了bean-demoPublisher发布的消息:" + msg);
        System.out.println("发生事件的对象是：" + event.getSource());
    }
}
