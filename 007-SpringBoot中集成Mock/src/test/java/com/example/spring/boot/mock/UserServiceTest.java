package com.example.spring.boot.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: 王俊超
 * Date: 2017-06-11 08:12
 * All Rights Reserved !!!
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MocksApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private NameService nameService;

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
        Mockito.when(nameService.getUserName("SomeId")).thenReturn("Mock user name");
        String testName = userService.getUserName("SomeId");
        Assert.assertEquals("Mock user name", testName);
    }
}
