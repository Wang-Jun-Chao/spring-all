package wjc.spring.cloud.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wjc.spring.cloud.customer.entity.SecurityUser;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-28 16:11
 **/
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final static Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Override
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)) {
            return new SecurityUser("user", "password1", "user-role");
        } else if ("admin".equals(username)) {
            return new SecurityUser("admin", "password2", "admin-role");
        } else {
            return null;
        }
    }
}
