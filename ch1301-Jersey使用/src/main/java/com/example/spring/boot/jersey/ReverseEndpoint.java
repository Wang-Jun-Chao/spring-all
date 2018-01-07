package com.example.spring.boot.jersey;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Author: 王俊超
 * Date: 2018-01-07 19-30
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
@Component
@Path("reverse")
public class ReverseEndpoint {
    @GET
    public String reverse(@QueryParam("input") @NotNull String input) {
        return new StringBuilder(input).reverse().toString();
    }

}
