package com.example.spring.boot.websocket.p2p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Author: 王俊超
 * Date: 2017-07-17 07:57
 * All Rights Reserved !!!
 */
@Controller
public class WsController {
    @Autowired
    private SimpMessagingTemplate template;
    @MessageMapping("/chat")
    public void handleChat(Principal principal, String message) {
        if (principal.getName().equals("wjc")) {
            template.convertAndSendToUser("wisely", "/queue/notifications",
                    principal.getName() + "-send: " + message);
        }else {
            template.convertAndSendToUser("wjc", "/queue/notifications",
                    principal.getName() + "-send: " + message);
        }
    }
}
