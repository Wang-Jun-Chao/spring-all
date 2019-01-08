package wjc.spring.cloud.consumer.feign.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-08 16:04
 **/
@Configuration
public class CustomerFeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
