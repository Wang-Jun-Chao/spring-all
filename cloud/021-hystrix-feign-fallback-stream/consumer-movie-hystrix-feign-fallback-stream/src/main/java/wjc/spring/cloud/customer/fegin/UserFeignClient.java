package wjc.spring.cloud.customer.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wjc.spring.cloud.customer.entity.User;
import wjc.spring.cloud.customer.service.FeignClientFallback;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-28 13:11
 **/
@FeignClient(name = "provider-user-hystrix-feign",
        fallback = FeignClientFallback.class)
public interface UserFeignClient {
    @GetMapping(value = "/user/{id}")
    User findById(@PathVariable("id") Long id);
}
