package wjc.spring.cloud.customer.fegin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wjc.spring.cloud.customer.entity.User;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-28 13:11
 **/
public interface UserFeignClient {
    @GetMapping(value = "/user/{id}")
    User findById(@PathVariable("id") Long id);
}
