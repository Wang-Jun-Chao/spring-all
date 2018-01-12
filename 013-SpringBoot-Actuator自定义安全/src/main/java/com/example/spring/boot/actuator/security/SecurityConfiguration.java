package com.example.spring.boot.actuator.security;

/**
 * Author: 王俊超
 * Date: 2018-01-12 07:32
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.security.StaticResourceRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withDefaultPasswordEncoder().username("user").password("password")
                        .authorities("ROLE_USER").build(),
                User.withDefaultPasswordEncoder().username("admin").password("admin")
                        .authorities("ROLE_ACTUATOR", "ROLE_USER").build());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(EndpointRequest.to("health", "info")).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ACTUATOR")
                .requestMatchers(StaticResourceRequest.toCommonLocations()).permitAll()
                .antMatchers("/foo").permitAll()
                .antMatchers("/**").hasRole("USER")
                .and()
                .cors()
                .and()
                .httpBasic();
    }

}
