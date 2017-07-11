package com.example.spring.framework.condition;

/**
 * Author: 王俊超
 * Date: 2017-07-11 08:12
 * All Rights Reserved !!!
 */
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
