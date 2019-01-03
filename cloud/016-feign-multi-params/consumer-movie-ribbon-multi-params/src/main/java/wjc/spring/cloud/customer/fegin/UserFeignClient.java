package wjc.spring.cloud.customer.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wjc.spring.cloud.customer.entity.User;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-28 13:11
 **/
@FeignClient(name = "provider-user-ribbon-multi-params")
public interface UserFeignClient {
    @GetMapping(value = "/user/{id}")
    User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/obj/get", method = RequestMethod.GET)
    User get(User user);
}
