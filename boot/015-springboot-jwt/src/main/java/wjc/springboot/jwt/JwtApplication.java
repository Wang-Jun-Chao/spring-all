package wjc.springboot.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-05 17:27
 **/
@SpringBootApplication
public class JwtApplication {
    private final static Logger logger = LoggerFactory.getLogger(JwtApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }
}
