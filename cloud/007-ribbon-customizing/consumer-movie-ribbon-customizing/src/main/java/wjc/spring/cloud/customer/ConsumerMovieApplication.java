package wjc.spring.cloud.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import wjc.spring.cloud.customer.config.RibbonConfiguration;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-26 14:06
 **/
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "provider-user-ribbon-customizing", configuration = RibbonConfiguration.class)
public class ConsumerMovieApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieApplication.class, args);
    }
}
