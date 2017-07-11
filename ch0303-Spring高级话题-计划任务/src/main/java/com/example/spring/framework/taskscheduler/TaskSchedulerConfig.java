package com.example.spring.framework.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Author: 王俊超
 * Date: 2017-07-11 08:04
 * All Rights Reserved !!!
 */
@Configuration
@ComponentScan("com.example.spring.framework.taskscheduler")
@EnableScheduling //1
public class TaskSchedulerConfig {
}
