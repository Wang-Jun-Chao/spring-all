package wjc.spring.cloud.customer.fegin;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import wjc.spring.cloud.customer.config.FeignConfiguration;
import wjc.spring.cloud.customer.entity.User;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-28 13:11
 **/
@FeignClient(name = "provider-user-feign-customizing",
        configuration = FeignConfiguration.class)
public interface UserFeignClient {
    @RequestLine("GET /user/{id}")
    User findById(@Param("id") Long id);
}
