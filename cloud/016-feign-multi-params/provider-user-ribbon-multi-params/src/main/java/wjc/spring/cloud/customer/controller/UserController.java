package wjc.spring.cloud.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wjc.spring.cloud.customer.entity.User;
import wjc.spring.cloud.customer.repository.UserRepository;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-26 14:07
 **/
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/get")
    public User get(User user) {
        return user;
    }

    @PostMapping("/user/post")
    public User post(@RequestBody User user) {
        return user;
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userRepository.getOne(id);
    }
}
