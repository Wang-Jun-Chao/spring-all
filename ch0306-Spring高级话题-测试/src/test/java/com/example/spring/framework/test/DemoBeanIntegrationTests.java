package com.example.spring.framework.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: 王俊超
 * Date: 2017-07-11 21:26
 * All Rights Reserved !!!
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("prod")
public class DemoBeanIntegrationTests {
    @Autowired
    private TestBean testBean;

    @Test
    public void prodBeanShouldInject() {
        String expected = "from production profile";
        String actual = testBean.getContent();
        Assert.assertEquals(expected, actual);
    }
}
