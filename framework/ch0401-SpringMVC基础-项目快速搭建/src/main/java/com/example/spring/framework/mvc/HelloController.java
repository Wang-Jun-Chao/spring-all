package com.example.spring.framework.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: 王俊超
 * Date: 2017-07-11 21:55
 * All Rights Reserved !!!
 */
@Controller
public class HelloController{
    @RequestMapping("/index")
    public String hello() {
        return "index";
    }
}
