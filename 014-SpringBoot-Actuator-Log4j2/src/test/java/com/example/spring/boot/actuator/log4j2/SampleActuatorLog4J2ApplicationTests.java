package com.example.spring.boot.actuator.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Author: 王俊超
 * Date: 2018-01-12 08:23
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleActuatorLog4J2ApplicationTests {

    private static final Logger logger = LogManager
            .getLogger(SampleActuatorLog4J2ApplicationTests.class);

    @Rule
    public OutputCapture output = new OutputCapture();

    @Autowired
    private MockMvc mvc;

    @Test
    public void testLogger() {
        logger.info("Hello World");
        this.output.expect(containsString("Hello World"));
    }

    @Test
    public void validateLoggersEndpoint() throws Exception {
        this.mvc.perform(
                get("/actuator/loggers/org.apache.coyote.http11.Http11NioProtocol")
                        .header("Authorization", "Basic " + getBasicAuth()))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"configuredLevel\":\"WARN\","
                        + "\"effectiveLevel\":\"WARN\"}")));
    }

    private String getBasicAuth() {
        return new String(Base64.getEncoder().encode(("user:password").getBytes()));
    }

}
