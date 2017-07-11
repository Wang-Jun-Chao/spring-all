package com.example.spring.framework.mvc.configuration.controller;

import com.example.spring.framework.mvc.configuration.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: 王俊超
 * Date: 2017-07-12 07:32
 * All Rights Reserved !!!
 */
@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj) {
        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute:"+ msg);
    }
}
