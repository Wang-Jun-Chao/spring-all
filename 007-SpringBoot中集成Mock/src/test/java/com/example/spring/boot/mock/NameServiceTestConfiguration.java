package com.example.spring.boot.mock;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Author: 王俊超
 * Date: 2017-06-11 08:11
 * All Rights Reserved !!!
 */
@Profile("test")
@Configuration
public class NameServiceTestConfiguration {
    @Bean
//    @Primary
    public NameService nameService() {
        return Mockito.mock(NameService.class);
    }
}
