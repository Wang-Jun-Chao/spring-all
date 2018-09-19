package com.example.spring.boot.websocket.p2p;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Author: 王俊超
 * Date: 2017-07-17 07:51
 * All Rights Reserved !!!
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login").permitAll() // 设置Spring Security 对/和/login路径不拦截。
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") // 设置Spring Security 的登录页面访问的路径为/login
                .defaultSuccessUrl("/chat") // 登录成功后转向/chat 路径。
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存中分别配置两个用户wjc和wisely，密码和用户名一致，角色是USER
        auth.inMemoryAuthentication()
                .withUser("wjc").password("wjc").roles("USER")
                .and()
                .withUser("wisely").password("wisely").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // /resources/static/目录下的静态资源， Spring Security 不拦截。
        web.ignoring().antMatchers("/resources/static/*");
    }
}
