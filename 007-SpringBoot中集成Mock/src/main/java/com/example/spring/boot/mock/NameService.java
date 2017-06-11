package com.example.spring.boot.mock;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Author: 王俊超
 * Date: 2017-06-11 08:06
 * All Rights Reserved !!!
 */
@Primary
@Service
public class NameService {
    public String getUserName(String id) {
        return "Real user name";
    }
}