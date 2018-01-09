package com.example.spring.boot.cxf.client;

import javax.ws.rs.*;

/**
 * Author: 王俊超
 * Date: 2018-01-09 22-21
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
@Consumes({"text/plain", "application/json"})
@Produces({"text/plain", "application/json"})
public interface HelloProxyController {
    @GET
    @Path("/hello/{message}")
    String hello(@PathParam("message") String message);
}
