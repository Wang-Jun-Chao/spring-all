package wjc.spring.cloud.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wjc.spring.cloud.provider.entity.User;
import wjc.spring.cloud.provider.repository.UserRepository;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-26 14:07
 **/
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        User findOne = this.userRepository.getOne(id);
        return findOne;
    }
}
