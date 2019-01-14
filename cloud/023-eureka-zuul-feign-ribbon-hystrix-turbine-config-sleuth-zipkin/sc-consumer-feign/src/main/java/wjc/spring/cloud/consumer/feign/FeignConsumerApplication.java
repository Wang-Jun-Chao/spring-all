package wjc.spring.cloud.consumer.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-08 15:59
 **/
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
@SpringBootApplication
public class FeignConsumerApplication {
    private final static Logger logger = LoggerFactory.getLogger(FeignConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }
}
