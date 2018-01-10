package com.example.spring.boot;

import com.example.spring.boot.activemq.Producer;
import com.example.spring.boot.activemq.SampleActiveMQApplication;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: 王俊超
 * Date: 2018-01-10 08:06
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
@SpringBootTest(classes = SampleActiveMQApplication.class)
@RunWith(SpringRunner.class)
public class SampleActiveMQTests {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    private Producer producer;

    @Test
    public void sendSimpleMessage() throws InterruptedException {
        this.producer.send("Test message");
        Thread.sleep(1000L);
        Assertions.assertThat(this.outputCapture.toString().contains("Test message")).isTrue();
    }
}
