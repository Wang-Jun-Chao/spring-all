package com.example.spring.boot.redis.dao;

import com.example.spring.boot.redis.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Author: 王俊超
 * Date: 2017-07-19 07:53
 * All Rights Reserved !!!
 */
@Repository
public class PersonDao {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOps;

    public void stringRedisTemplateDemo(){ //5
        valOpsStr.set("xx", "yy");
    }


    public void save(Person person){ //6
        valOps.set(person.getId(),person);
    }

    public String getString(){//7
        return valOpsStr.get("xx");
    }

    public Person getPerson(){//8
        return (Person) valOps.get("1");
    }
}
