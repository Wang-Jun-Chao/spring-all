package com.example.spring.framework.converter.controller;

import com.example.spring.framework.converter.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: 王俊超
 * Date: 2017-07-13 07:56
 * All Rights Reserved !!!
 */
@Controller
public class ConverterController {
    @RequestMapping(value = "/converter")
    public @ResponseBody
    DemoObj converter(@RequestBody DemoObj obj) {
        return obj;
    }
}
