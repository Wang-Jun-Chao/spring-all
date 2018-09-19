package com.example.spring.framework.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ①通过＠Scheduled 声明该方法是计划任务，使用fixedRate 属性每隔固定时间执行。
 * ②使用cron 属性可按照指定时间执行，本例指的是每天11 点28 分执行；
 * cron 是UNIX和类UNIX ( Linux ）系统下的定时任务。
 * Author: 王俊超
 * Date: 2017-07-11 08:04
 * All Rights Reserved !!!
 */
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTime() {
        System.out.println("每隔五秒执行一次 " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 28 11 ? * *") //2
    public void fixTimeExecution() {
        System.out.println("在指定时间 " + dateFormat.format(new Date()) + "执行");
    }
}
