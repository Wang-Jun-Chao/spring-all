package com.example.spring.framework.mvc.configuration.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebResult;

/**
 * Author: 王俊超
 * Date: 2017-07-12 07:28
 * All Rights Reserved !!!
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息"); //3
    }

    @InitBinder //4
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id"); //5
    }
}
