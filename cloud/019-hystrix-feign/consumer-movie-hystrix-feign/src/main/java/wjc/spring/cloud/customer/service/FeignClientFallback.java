package wjc.spring.cloud.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import wjc.spring.cloud.customer.entity.User;
import wjc.spring.cloud.customer.fegin.UserFeignClient;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-04 14:16
 **/
@Component
public class FeignClientFallback implements UserFeignClient {
    private final static Logger logger = LoggerFactory.getLogger(FeignClientFallback.class);

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("default");

        return user;
    }
}
