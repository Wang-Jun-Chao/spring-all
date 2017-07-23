package com.example.spring.boot.microservice.ui.service;

import com.example.spring.boot.microservice.ui.domain.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: 王俊超
 * Date: 2017-07-23 17:27
 * All Rights Reserved !!!
 */
@FeignClient("person")
public interface PersonService {
    @RequestMapping(
            method = RequestMethod.POST, value = "/save",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<Person> save(@RequestBody String name);
}
