package wjc.spring.cloud.dashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-08 16:37
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
public class DashboardApplication {
    private final static Logger logger = LoggerFactory.getLogger(DashboardApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class, args);
    }
}
