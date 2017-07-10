package com.example.spring.framework.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Author: 王俊超
 * Date: 2017-07-10 22:47
 * All Rights Reserved !!!
 */
@Service
public class DemoService {
    @Value("其他类的属性") //1
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }

}
