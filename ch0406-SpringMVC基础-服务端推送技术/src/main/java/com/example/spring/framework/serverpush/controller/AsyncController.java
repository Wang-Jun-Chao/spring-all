package com.example.spring.framework.serverpush.controller;

import com.example.spring.framework.serverpush.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * 异步任务的实现是通过控制器从另外一个线程返回一个DeferredResult，这里的
 * DeferredResult 是从pushService 中获得的。
 * Author: 王俊超
 * Date: 2017-07-14 07:44
 * All Rights Reserved !!!
 */
@Controller
public class AsyncController {
    @Autowired
    PushService pushService; // ①定时任务，定时更新DeferredResulto

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall() {
        return pushService.getAsyncUpdate(); // ②返回给客户端DeferredResulto
    }
}
