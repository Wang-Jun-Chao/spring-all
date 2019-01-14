package wjc.spring.cloud.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-08 13:35
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApplication {
    private final static Logger logger = LoggerFactory.getLogger(ProviderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
