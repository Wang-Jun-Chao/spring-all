package wjc.spring.boot.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-26 15:43
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    private final static Logger logger = LoggerFactory.getLogger(EurekaServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
