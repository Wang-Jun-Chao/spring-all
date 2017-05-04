package com.wisely.spring_boot_starter_hello;

/**
 * Author: 王俊超
 * Date: 2017-04-25 07:56
 * All Rights Reserved !!!
 */
public class HelloService {
    private String msg;

    public String sayHello(){
        return "Hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
