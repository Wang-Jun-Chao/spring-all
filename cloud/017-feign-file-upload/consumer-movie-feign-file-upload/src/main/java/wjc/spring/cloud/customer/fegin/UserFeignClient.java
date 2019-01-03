package wjc.spring.cloud.customer.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wjc.spring.cloud.customer.entity.User;

import java.util.Map;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-28 13:11
 **/
@FeignClient(name = "provider-user-ribbon-file-upload")
public interface UserFeignClient {

    // 该请求不会成功
    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public User get0(User user);

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public User get1(@RequestParam("id") Long id, @RequestParam("username") String username);

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public User get2(@RequestParam Map<String, Object> map);

    @RequestMapping(value = "/user/post", method = RequestMethod.POST)
    public User post(@RequestBody User user);

    @GetMapping(value = "/user/{id}")
    User findById(@PathVariable("id") Long id);
}
