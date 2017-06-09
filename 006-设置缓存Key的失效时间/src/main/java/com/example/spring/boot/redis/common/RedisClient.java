package com.example.spring.boot.redis.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;


/**
 * Author: 王俊超
 * Date: 2017-06-04 19:57
 * All Rights Reserved !!!
 */
@Component("redisClient")
public class RedisClient {
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    /**
     * 取redis连接
     *
     * @return
     */
    private RedisConnection getConnection() {
        return redisTemplate.getConnectionFactory().getConnection();
    }

    /**
     * 获取缓存的key
     *
     * @param key
     * @return
     */
    private byte[] getKey(String cacheName, String key) {
        return (cacheName+":" + key).getBytes();
    }

    /**
     * 删除redis中的对象
     *
     * @param cacheName
     * @param key
     */
    public <T> void delete(String cacheName, String key) {
        getConnection().del(getKey(cacheName, key));
    }

    /**
     * 更新缓存中的对象，也可以在redis缓存中存入新的对象
     *
     * @param cacheName
     * @param key
     * @param t
     * @param <T>
     */
    public <T> void set(String cacheName, String key, T t) {
        byte[] keyBytes = getKey(cacheName, key);
        RedisSerializer serializer = redisTemplate.getValueSerializer();
        byte[] val = serializer.serialize(t);
        getConnection().set(keyBytes, val);

    }

    /**
     * 从缓存中取对象
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getObject(String cacheName, String key) {
        byte[] keyBytes = getKey(cacheName, key);
        byte[] result = getConnection().get(keyBytes);
        return (T) redisTemplate.getValueSerializer().deserialize(result);
    }


}
