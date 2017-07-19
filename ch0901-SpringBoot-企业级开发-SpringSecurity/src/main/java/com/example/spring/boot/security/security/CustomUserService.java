package com.example.spring.boot.security.security;

import com.example.spring.boot.security.dao.SysUserRepository;
import com.example.spring.boot.security.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Author: 王俊超
 * Date: 2017-07-19 21:26
 * All Rights Reserved !!!
 */
public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        return user;
    }
}
