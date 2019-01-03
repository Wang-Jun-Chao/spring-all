package wjc.spring.cloud.customer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wjc.spring.cloud.customer.entity.User;
import wjc.spring.cloud.customer.fegin.UserFeignClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-26 14:07
 **/
@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 测试URL：http://localhost:8000/user/get0?id=1&username=张三
     * 该请求不会成功。
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get0")
    public User get0(User user) {
        return this.userFeignClient.get0(user);
    }

    /**
     * 测试URL：http://localhost:8000/user/get1?id=1&username=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get1")
    public User get1(User user) {
        return this.userFeignClient.get1(user.getId(), user.getUsername());
    }

    /**
     * 测试URL：http://localhost:8000/user/get2?id=1&username=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get2")
    public User get2(User user) {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> value = mapper.convertValue(user, Map.class);
        return this.userFeignClient.get2(value);
    }

    /**
     * 测试URL:http://localhost:8000/user/post?id=1&username=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/post")
    public User post(User user) {
        return this.userFeignClient.post(user);
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }
}
