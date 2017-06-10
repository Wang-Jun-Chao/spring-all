package com.example.spring.boot.redis.aspect;

import com.example.spring.boot.redis.annotation.RedisCachePut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;


/**
 * Author: 王俊超
 * Date: 2017-06-10 06:17
 * All Rights Reserved !!!
 */
@Aspect
@Component
public class RedisCacheAspect {
    private final static char DOT = '.';
    private final static char SHARP = '#';
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    public RedisTemplate<Object, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(cachePut)")
    public Object cachePut(ProceedingJoinPoint pjp, RedisCachePut cachePut) throws Exception {
        System.out.println("=========================");

        for (Object arg : pjp.getArgs()) {
            System.out.println(arg + " " + arg.getClass());
        }

        Object keyObject = getCacheKey(pjp, cachePut);
        System.out.println(keyObject);

        return null;
    }


    private String getCacheKey(ProceedingJoinPoint pjp, RedisCachePut cachePut) throws Exception {

        String key = cachePut.key();

        // 以#开头
        if (key.length() > 0 && key.charAt(0) == SHARP) {
            // 去掉#
            key = key.substring(1);
            // 将key分割成属性和参数名，第一个“.”之前是参数名，之后是属性名称
            int dotIdx = key.indexOf(DOT);
            String argName = key;
            if (dotIdx > 0) {
                argName = key.substring(0, dotIdx);
                key = key.substring(dotIdx + 1);
            }

            // 取参数值
            Object argVal = getArg(pjp, argName);

            // 获取参数的属性值
            Object objectKey = argVal;
            if (dotIdx > 0) {
                objectKey =  getObjectKey(argVal, key);
            }

            return objectKey == null ? null : objectKey.toString();

        } else { // 不是以#开头的就以其值作为参数key
            return key;
        }
    }

    /**
     * 获取参数对象
     *
     * @param pjp
     * @param parameterName
     * @return
     */
    private Object getArg(ProceedingJoinPoint pjp, String parameterName) throws NoSuchMethodException {

        Method method = getAdvicedMethod(pjp);
        ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
        if (parameterNames != null) {
            int idx = 0;
            for (String name : parameterNames) {
                System.out.println(name);
                if (name.equals(parameterName)) {
                    return pjp.getArgs()[idx];
                }
                idx++;
            }
        }

        throw new IllegalArgumentException("no such parameter name: [" + parameterName + "] in method: " + method);
    }

    /**
     * 获取拦截的方法
     *
     * @param pjp
     * @return
     * @throws NoSuchMethodException
     */
    private Method getAdvicedMethod(ProceedingJoinPoint pjp) throws NoSuchMethodException {
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = pjp.getTarget();
        return target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
    }

    /**
     * 获取从object上获取key所对应的属性对象
     * 例如：key: country.province.city.town
     * 就相当于调用：object.getCountry().getProvince().getCity.getTown()
     *
     * @param object
     * @param key
     * @return
     * @throws Exception
     */
    private Object getObjectKey(Object object, String key) throws Exception {
        // 如果key已经是空了就直接返回
        if (StringUtils.isEmpty(key)) {
            return object;
        }

        int dotIdx = key.indexOf(DOT);
        // 形如key=aa.bb**的情况
        if (dotIdx > 0) {
            // 取第一个属性值
            String propertyName = key.substring(0, dotIdx);
            // 取剩下的key
            key = key.substring(dotIdx + 1);

            Object property = getProperty(object, getterMethod(propertyName));
            return getObjectKey(property, key);
        } else { // key=aa
            return getProperty(object, getterMethod(key));
        }
    }

    /**
     * 获取name的getter方法名称
     *
     * @param name
     * @return
     */
    public String getterMethod(String name) {
        return "get" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    /**
     * 调用obj对象上的getterMethodName
     *
     * @param obj
     * @param getterMethodName
     * @return
     * @throws Exception
     */
    public Object getProperty(Object obj, String getterMethodName) throws Exception {
        return obj.getClass().getMethod(getterMethodName).invoke(obj);
    }
}
