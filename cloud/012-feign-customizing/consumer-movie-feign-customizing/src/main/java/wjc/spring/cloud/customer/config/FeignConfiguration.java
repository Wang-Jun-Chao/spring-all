package wjc.spring.cloud.customer.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-28 13:38
 **/
public class FeignConfiguration {
    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }
}
