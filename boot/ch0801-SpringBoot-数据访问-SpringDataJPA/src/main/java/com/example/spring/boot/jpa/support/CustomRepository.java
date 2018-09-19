package com.example.spring.boot.jpa.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Author: 王俊超
 * Date: 2017-07-17 21:00
 * All Rights Reserved !!!
 */
@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    Page<T> findByAuto(T example, Pageable pageable);

}
