package com.wisely.ch10war;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Ch10warApplication.class)
@WebAppConfiguration
public class Ch10warApplicationTests {

    @Test
    public void contextLoads() {
    }

}
