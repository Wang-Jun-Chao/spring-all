package wjc.spring.cloud.consumer.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wjc.spring.cloud.consumer.feign.config.CustomerFeignConfig;
import wjc.spring.cloud.consumer.feign.fallback.CustomerFeignClientFallback;

import java.util.List;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-08 16:03
 **/
@FeignClient(name = "sc-provider", fallback = CustomerFeignClientFallback.class,
        configuration = CustomerFeignConfig.class)
public interface ConsumerFeignClient {
    /**
     * 这是被请求微服务的地址，也就是provider的地址
     *
     * @param
     * @return
     * @author: wangjunchao(王俊超)
     * @date: 2019-01-08 16:07:06
     **/
    @GetMapping(value = "/test/{msg}")
    String sayHelloWorld(@PathVariable("msg") String msg);

    @GetMapping(value = "/test/list")
    List<Integer> list();

    @GetMapping(value = "/test/list")
    Integer[] array();
}
