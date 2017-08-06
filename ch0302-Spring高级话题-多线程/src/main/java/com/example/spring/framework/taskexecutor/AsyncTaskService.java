package com.example.spring.framework.taskexecutor;

        import org.springframework.scheduling.annotation.Async;
        import org.springframework.stereotype.Service;

/**
 * ①通过＠Async 注解表明该方法是个异步方法，如果注解在类级别，则表明该类所有的
 * 方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor 作为TaskExecutor
 * Author: 王俊超
 * Date: 2017-07-11 07:59
 * All Rights Reserved !!!
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务: " + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("执行异步任务+1: " + (i + 1));
    }
}
