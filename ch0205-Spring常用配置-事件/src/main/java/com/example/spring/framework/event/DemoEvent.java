package com.example.spring.framework.event;

import org.springframework.context.ApplicationEvent;

/**
 * Author: 王俊超
 * Date: 2017-07-11 07:33
 * All Rights Reserved !!!
 */
public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String msg;

    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
