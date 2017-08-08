package com.example.spring.framework.mvc.configuration.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 1、@Controller Advice 声明一个控制器建言，@ControllerAdvice 组合了@Component 注解，
 * 所以自动注册为Spring 的Bean
 * 2、@ExceptionHandler 在此处定义全局处理，通@ExceptionHandler 的value 属性可过
 * 滤拦截的条件，在此处我们可以看出我们拦截所有的Exception
 * 3、此处使用＠ModelAttribute 注解将键值对添加到全局，所有注解的@RequestMapping
 * 的方法可获得此键值对。
 * 4、通过@InitBinder 注解定制WebDataBinder
 * 5、此处演示忽略request 参数的id ，更多关于WebDataBinder 的自己置，请参考
 * WebDataBinder 的API 文档。
 * Author: 王俊超
 * Date: 2017-07-12 07:28
 * All Rights Reserved !!!
 */
@ControllerAdvice // 1
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = Exception.class) // 2
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute // 3
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息"); //3
    }

    @InitBinder //4
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id"); //5
    }
}
