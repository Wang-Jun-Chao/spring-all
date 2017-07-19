package com.example.spring.boot.security.dao;

import com.example.spring.boot.security.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);

}
