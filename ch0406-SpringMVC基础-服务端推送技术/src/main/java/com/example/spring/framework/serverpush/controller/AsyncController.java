package com.example.spring.framework.serverpush.controller;

import com.example.spring.framework.serverpush.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Author: 王俊超
 * Date: 2017-07-14 07:44
 * All Rights Reserved !!!
 */
@Controller
public class AsyncController {
    @Autowired
    PushService pushService;

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall() {
        return pushService.getAsyncUpdate();
    }
}
