package com.example.spring.boot.jersey;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Author: 王俊超
 * Date: 2018-01-07 19-22
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */

@Component
@Path("/hello")
public class Endpoint {
    private Service service;

    public Endpoint(Service service) {
        this.service = service;
    }

    @GET
    public String message() {
        return "hello " + this.service.message();
    }
}
