package com.example.spring.boot.cxf.server;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 王俊超
 * Date: 2018-01-09 22:19
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
@RestController
public class HelloController {
    @RequestMapping(
            value = "/hello/{message}",
            method = RequestMethod.GET)
    public String hello(@PathVariable("message") String message) {
        return "Hello " + message + "!";
    }
}
