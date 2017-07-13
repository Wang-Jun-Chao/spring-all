package com.example.spring.framework.serverpush.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.attribute.standard.Media;
import java.util.Random;

/**
 * Author: 王俊超
 * Date: 2017-07-14 07:34
 * All Rights Reserved !!!
 */
@Controller
public class SeeController {
    @RequestMapping(value = "/push", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public @ResponseBody
    String push() {
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "data:Testing 1,2,3,...," + r.nextInt() + "\n\n";
    }
}
