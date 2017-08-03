package com.example.spring.framework.serverpush.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Author: 王俊超
 * Date: 2017-07-14 07:45
 * All Rights Reserved !!!
 */
@Service
public class PushService {
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate() {
        deferredResult = new DeferredResult<>();
        return deferredResult;
    }

    /**
     * ①在PushService 里产生DeferredResult ~合控制器使用，通过＠Scheduled
     * 注解的方法定时更新DeferredResulto
     */
    @Scheduled(fixedDelay = 5000)
    public void refresh() {
        if (deferredResult != null) {
            deferredResult.setResult(Long.toString(System.currentTimeMillis()));
        }
    }
}
