package com.example.spring.boot.security.dao;

import com.example.spring.boot.security.domain.SysRole;
import com.example.spring.boot.security.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: 王俊超
 * Date: 2017-07-19 21:26
 * All Rights Reserved !!!
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
