package com.example.spring.boot.websocket;

/**
 * Author: 王俊超
 * Date: 2017-07-17 07:38
 * All Rights Reserved !!!
 */
public class WiselyResponse {

    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
