package wjc.spring.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-04 16:24
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {
    private final static Logger logger = LoggerFactory.getLogger(HystrixDashboardApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
