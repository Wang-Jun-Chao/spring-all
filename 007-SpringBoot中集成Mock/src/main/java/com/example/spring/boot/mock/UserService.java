package com.example.spring.boot.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: 王俊超
 * Date: 2017-06-11 08:07
 * All Rights Reserved !!!
 */
@Service
public class UserService {

    @Autowired
    private NameService nameService;


    public String getUserName(String id) {
        return nameService.getUserName(id);
    }
}