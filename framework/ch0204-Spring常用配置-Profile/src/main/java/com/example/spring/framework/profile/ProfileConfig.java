package com.example.spring.framework.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * ① Profile 为dev 时实例化devDemoBean。
 * ② Profile 为prod 时实例化prodDemoBean。
 * Author: 王俊超
 * Date: 2017-07-11 07:26
 * All Rights Reserved !!!
 */
public class ProfileConfig {

    @Bean
    @Profile("dev") //1
    public DemoBean devDemoBean() {
        return new DemoBean("from development profile");
    }

    @Bean
    @Profile("prod") //2
    public DemoBean prodDemoBean() {
        return new DemoBean("from production profile");
    }
}
