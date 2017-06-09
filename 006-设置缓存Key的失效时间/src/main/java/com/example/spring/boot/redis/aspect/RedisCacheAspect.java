package com.example.spring.boot.redis.aspect;

import com.example.spring.boot.redis.annotation.RedisCachePut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2017-06-10 06:17
 * All Rights Reserved !!!
 */
@Aspect
@Component
public class RedisCacheAspect {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    public RedisTemplate<Object, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("execution( @com.example.spring.boot.redis.annotation.RedisCachePut * *(..)) && " +
            "@annotation(cachePut)")
    public Object cachePut(ProceedingJoinPoint pjp, RedisCachePut cachePut) {

        String key = getCacheKey(pjp, cachePut);

        return null;
    }

//    private Method getMethod(ProceedingJoinPoint pjp) throws NoSuchMethodException {
//        Signature sign = pjp.getSignature();
//        if (!(sign instanceof MethodSignature)) {
//            throw new IllegalArgumentException("该注解只能用于方法");
//        }
//        MethodSignature methodSignature = (MethodSignature) sign;
//        Object target = pjp.getTarget();
//        return  target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
//    }

    private String getCacheKey(ProceedingJoinPoint pjp, RedisCachePut cachePut) {

        String key;
        Object[] args = pjp.getArgs();
        System.out.println(Arrays.toString(args));
        return null;
    }
}
