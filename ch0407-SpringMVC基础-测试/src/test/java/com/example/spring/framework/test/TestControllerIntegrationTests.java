package com.example.spring.framework.test;

import com.example.spring.framework.test.config.MyMvcConfig;
import com.example.spring.framework.test.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 1、@WebAppConfiguration 注解在类上，用来声明加载的ApplicationContex 是一个WebApplicationContext
 * 它的属性指定的是Web 资源的位置，默认为src/main/webapp ，本例修改为src/main/resources
 * 2、MockMvc模拟MVC对象
 * 3、可以在测试用例中注入Spring 的Bean
 * Author: 王俊超
 * Date: 2017-07-14 08:17
 * All Rights Reserved !!!
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MyMvcConfig.class)
@WebAppConfiguration("src/main/resources")
public class TestControllerIntegrationTests {
    private MockMvc mockMvc;

    @Autowired
    private DemoService demoService;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    MockHttpSession session;

    @Autowired
    private MockHttpServletRequest request;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testNormalController() throws Exception {
        mockMvc.perform(get("/normal"))
                .andExpect(status().isOk())
                .andExpect(view().name("page"))
                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))
                .andExpect(model().attribute("msg", demoService.saySomething()));
    }

    @Test
    public void testRestController() throws Exception {
        mockMvc.perform(get("/testRest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(demoService.saySomething()));
    }
}
