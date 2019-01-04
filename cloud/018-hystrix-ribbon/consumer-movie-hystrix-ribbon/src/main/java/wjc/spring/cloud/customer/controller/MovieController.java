package wjc.spring.cloud.customer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import wjc.spring.cloud.customer.entity.User;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-26 14:07
 **/
@RestController
public class MovieController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://pprovider-user-hystrix-ribbon/user/" + id, User.class);
    }

    @GetMapping("/log-user-instance")
    public String logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider-user-hystrix-ribbon");
        return String.format("%s:%s:%s", serviceInstance.getServiceId(),
                serviceInstance.getHost(), serviceInstance.getPort());
    }

    public User findByIdFallback(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("default");

        return user;
    }
}
