package com.example.spring.boot.hello;

/**
 * Author: 王俊超
 * Date: 2017-07-16 09:19
 * All Rights Reserved !!!
 */
public class HelloService {
    private String msg;

    public String sayHello() {
        return "Hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
