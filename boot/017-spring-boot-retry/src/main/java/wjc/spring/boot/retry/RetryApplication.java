package wjc.spring.boot.retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-05-20 16:06
 **/
@EnableRetry
@SpringBootApplication
public class RetryApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(RetryApplication.class, args);
        RemoteService remoteService = SpringContextUtils.getBean(RemoteService.class);
        remoteService.call();
    }
}
