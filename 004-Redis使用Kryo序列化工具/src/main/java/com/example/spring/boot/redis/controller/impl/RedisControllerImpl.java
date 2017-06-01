package com.example.spring.boot.redis.controller.impl;

import com.example.spring.boot.redis.controller.RedisController;
import com.example.spring.boot.redis.entity.Person;
import com.example.spring.boot.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;

/**
 * Author: 王俊超
 * Date: 2017-05-07 09:57
 * All Rights Reserved !!!
 */
@RestController
public class RedisControllerImpl implements RedisController {

    @Autowired
    RedisService redisService;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;


    @RequestMapping("/put")
    public Person put(Person person) {
        return redisService.save(person);
    }


    @RequestMapping("/able")
    public Person cacheable(Person person) {
        return redisService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id) {
        redisService.remove(id);
        return "ok";
    }

    @RequestMapping("/cache")
    public Person cache(Long id) {
        RedisSerializer serializer = redisTemplate.getKeySerializer();
//        byte[] bytes = (byte[]) redisTemplate.opsForHash().get("people", serializer.serialize(id));
        byte[] bs = serializer.serialize(id);

        Set<byte[]> keySet = redisTemplate.getConnectionFactory().getConnection().keys("*".getBytes());

        byte[] prefixBytes = "people:".getBytes();
        byte[] key = new byte[prefixBytes.length + bs.length];

        System.arraycopy(prefixBytes, 0, key, 0, prefixBytes.length);
        System.arraycopy(bs, 0, key, prefixBytes.length, bs.length);


        byte[] result = redisTemplate.getConnectionFactory().getConnection().get(key);
        System.out.println(serializer.deserialize(result));

        byte[] bytes = redisTemplate.dump(key);
        System.out.println(Arrays.toString(key));
        System.out.println(redisTemplate.hasKey(key));
        System.out.println(Arrays.toString(bytes));

        Set<Object> keys = redisTemplate.keys("*");
        System.out.println(keys);
        serializer = redisTemplate.getValueSerializer();
        return (Person) serializer.deserialize(bytes);
    }
}
