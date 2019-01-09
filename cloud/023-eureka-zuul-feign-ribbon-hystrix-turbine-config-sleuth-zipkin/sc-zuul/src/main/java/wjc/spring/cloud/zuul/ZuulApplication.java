package wjc.spring.cloud.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-08 16:31
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
@RefreshScope
public class ZuulApplication {
    private final static Logger logger = LoggerFactory.getLogger(ZuulApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
