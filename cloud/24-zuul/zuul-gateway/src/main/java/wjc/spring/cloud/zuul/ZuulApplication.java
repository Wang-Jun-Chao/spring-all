package wjc.spring.cloud.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-15 15:11
 **/
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    private final static Logger logger = LoggerFactory.getLogger(ZuulApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
