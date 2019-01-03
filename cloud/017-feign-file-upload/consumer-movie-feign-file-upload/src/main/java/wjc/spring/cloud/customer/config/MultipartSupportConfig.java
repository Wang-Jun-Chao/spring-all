package wjc.spring.cloud.customer.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-03 16:26
 **/
public class MultipartSupportConfig {
    private final static Logger logger = LoggerFactory.getLogger(MultipartSupportConfig.class);

    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }
}
