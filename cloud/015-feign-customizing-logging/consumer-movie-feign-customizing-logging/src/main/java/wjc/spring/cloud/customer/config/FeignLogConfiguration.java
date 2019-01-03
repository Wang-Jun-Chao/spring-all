package wjc.spring.cloud.customer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-28 17:26
 **/
public class FeignLogConfiguration {
    private final static Logger logger = LoggerFactory.getLogger(FeignLogConfiguration.class);

    @Bean
    feign.Logger.Level feignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }
}
