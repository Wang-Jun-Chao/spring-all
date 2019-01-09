package wjc.spring.cloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-08 13:52
 **/
@RestController
public class RibbonController {
    private final static Logger logger = LoggerFactory.getLogger(RibbonController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/ribbon/{wd}")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public Mono<String> sayHelloWorld(@PathVariable("wd") String parm) {
        String res = this.restTemplate.getForObject("http://sc-provider/test/" + parm, String.class);
        return Mono.just(res);
    }

    public Mono<String> fallbackMethod(@PathVariable("wd") String parm) {
        return Mono.just("fallback");
    }
}
