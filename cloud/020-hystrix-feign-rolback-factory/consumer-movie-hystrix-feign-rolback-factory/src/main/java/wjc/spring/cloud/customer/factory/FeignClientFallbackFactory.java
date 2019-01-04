package wjc.spring.cloud.customer.factory;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import wjc.spring.cloud.customer.entity.User;
import wjc.spring.cloud.customer.fegin.UserFeignClient;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-04 15:38
 **/
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    private final static Logger logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                logger.info("fallback; reason was: ", cause);
                User user = new User();
                user.setId(-1L);
                user.setUsername("default");

                return user;
            }
        };
    }
}
