package wjc.spring.cloud.consumer.feign.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import wjc.spring.cloud.consumer.feign.client.ConsumerFeignClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-08 16:04
 **/
@Component
public class CustomerFeignClientFallback implements ConsumerFeignClient {
    private final static Logger logger = LoggerFactory.getLogger(CustomerFeignClientFallback.class);

    @Override
    public String sayHelloWorld(String msg) {
        return "fallback";
    }

    @Override
    public List<Integer> list() {
        return new ArrayList<>();
    }

    @Override
    public Integer[] array() {
        return new Integer[0];
    }
}
