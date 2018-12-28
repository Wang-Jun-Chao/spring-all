package wjc.spring.cloud.customer.config;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-27 14:26
 **/
public class DefaultRibbonConfiguration {
    private final static Logger logger = LoggerFactory.getLogger(DefaultRibbonConfiguration.class);

    @Bean
    public IRule ribbonRule() {
        return new BestAvailableRule();
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }
}
