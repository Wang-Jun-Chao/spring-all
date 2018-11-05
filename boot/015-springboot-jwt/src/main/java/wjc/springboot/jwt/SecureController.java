package wjc.springboot.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-05 17:44
 **/
@RestController
@RequestMapping("/secure")
public class SecureController {
    private final static Logger logger = LoggerFactory.getLogger(SecureController.class);
    @RequestMapping("/users/user")
    public String loginSuccess() {
        return "Login Successful!";
    }
}
