package com.example.spring.framework.test.controller;

import com.example.spring.framework.test.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: 王俊超
 * Date: 2017-07-14 20:42
 * All Rights Reserved !!!
 */
@Controller
public class NormalController {
    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/normal", produces = "text/plain;charset=UTF-8")
    public String testPage(Model model) {
        model.addAttribute("msg", demoService.saySomething());

        return "page";
    }
}
