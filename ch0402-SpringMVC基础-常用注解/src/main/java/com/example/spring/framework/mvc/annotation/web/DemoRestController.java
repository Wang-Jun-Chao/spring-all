package com.example.spring.framework.mvc.annotation.web;

import com.example.spring.framework.mvc.annotation.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 王俊超
 * Date: 2017-07-11 22:12
 * All Rights Reserved !!!
 */
@RestController //1
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getjson",
            produces = {"application/json;charset=UTF-8"}) //2
    public DemoObj getjson(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + "yy");//3
    }

    @RequestMapping(value = "/getxml",
            produces = {"application/xml;charset=UTF-8"})//4
    public DemoObj getxml(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + "yy");
    }

}
