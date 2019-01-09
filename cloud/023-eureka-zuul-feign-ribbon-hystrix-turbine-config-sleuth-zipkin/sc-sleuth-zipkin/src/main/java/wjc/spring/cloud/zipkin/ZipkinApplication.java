package wjc.spring.cloud.zipkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-08 16:45
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication {
    private final static Logger logger = LoggerFactory.getLogger(ZipkinApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }
}
