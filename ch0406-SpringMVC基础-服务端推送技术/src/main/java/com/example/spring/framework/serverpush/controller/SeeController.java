package com.example.spring.framework.serverpush.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Author: 王俊超
 * Date: 2017-07-14 07:34
 * All Rights Reserved !!!
 */
@Controller
public class SeeController {
    /**
     * ①注意，这里使用输出的媒体类型为text/event-stream ，这是服务器端SSE 的支持，
     * 本例演示每5 秒钟向浏览器推送随机消息。
     */
    @RequestMapping(value = "/push", produces = "text/event-stream;charset=UTF-8")
    public @ResponseBody
    String push() {
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "data:Testing 1,2,3,...," + r.nextInt() + "\n\n";
    }
}
