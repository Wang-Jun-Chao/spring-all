package com.example.spring.boot.redis.service.impl;

import com.example.spring.boot.redis.entity.Person;
import com.example.spring.boot.redis.mapper.PersonMapper;
import com.example.spring.boot.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: 王俊超
 * Date: 2017-05-07 09:58
 * All Rights Reserved !!!
 */
@Service
@Transactional(readOnly = true)
public class RedisServiceImpl implements RedisService {
    @Autowired
    PersonMapper personRepository;



    /**
     * 创建对象，并且将person对象入缓存，key是person对象的id
     * @param person
     * @return
     */
    @Override
    @CachePut(value = "people", key = "#person.id")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Person save(Person person) {
        personRepository.save(person);
        System.out.println("为id、key为:" + person.getId() + "数据做了缓存");
        return person;
    }

    /**
     * 从缓存中删除person对象，key是person对象的id
     * @param id
     */
    @Override
    @CacheEvict(value = "people") //2
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void remove(Long id) {
        System.out.println("删除了id、key为" + id + "的数据缓存");
        //这里不做实际删除操作
    }

    /**
     * 更新对象，并且将person对象入缓存，key是person对象的id
     *
     * @param person
     * @return
     */
    @Override
    @Cacheable(value = "people", key = "#person.id") //3
    public Person findOne(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }
}
