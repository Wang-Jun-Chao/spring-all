package com.example.spring.boot.cxf.client;

import java.util.Collections;

/**
 * Author: 王俊超
 * Date: 2018-01-09 22-20
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class ClientRunner {
    public static void main(String[] args) {
        HelloProxyController proxy = ControllerProxyFactory.createControllerProxy(HelloProxyController.class,
                "http://localhost:8080", Collections.emptyMap());

        String message = proxy.hello("WangJunchao");

        System.out.println(message);
    }
}
