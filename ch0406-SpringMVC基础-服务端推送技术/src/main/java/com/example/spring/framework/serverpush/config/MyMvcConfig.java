package com.example.spring.framework.serverpush.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Author: 王俊超
 * Date: 2017-07-12 07:22
 * All Rights Reserved !!!
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.example.spring.framework.serverpush")
public class MyMvcConfig extends WebMvcConfigurerAdapter{
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);

        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
        super.addResourceHandlers(registry);
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/see").setViewName("/see");
        registry.addViewController("/async").setViewName("/async");
    }

//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//        converters.add(converter());
//
//    }
//
//    @Bean
//    public MyMessageConverter converter() {
//        return new MyMessageConverter();
//    }


}
