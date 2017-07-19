package com.example.spring.boot.security.controller;

import com.example.spring.boot.security.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * Author: 王俊超
 * Date: 2017-07-19 21:29
 * All Rights Reserved !!!
 */
@Controller
public class HomeController {
    public String index(Model model) {
        Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }
}
