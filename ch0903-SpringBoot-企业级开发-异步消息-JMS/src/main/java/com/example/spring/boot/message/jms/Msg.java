package com.example.spring.boot.message.jms;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Author: 王俊超
 * Date: 2017-07-23 10:55
 * All Rights Reserved !!!
 */
public class Msg implements MessageCreator {

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("测试消息");
    }

}
