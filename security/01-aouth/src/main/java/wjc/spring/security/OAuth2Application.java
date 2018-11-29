package wjc.spring.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-05 19:47
 **/
@SpringBootApplication
public class OAuth2Application {
    private final static Logger logger = LoggerFactory.getLogger(OAuth2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application.class, args);
    }
}
