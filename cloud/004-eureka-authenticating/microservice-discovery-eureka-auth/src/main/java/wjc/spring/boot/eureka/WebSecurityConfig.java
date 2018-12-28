package wjc.spring.boot.eureka;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 说是新版（Spring Cloud 2.0 以上）的security默认启用了csrf检验，
 * 要在eurekaServer端配置security的csrf检验为false
 *
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-27 11:25
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }
}
