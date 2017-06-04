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
     * @param id
     * @return
     */
    private <T> byte[] getKey(T id) {
        // 在spring data redis中，使用@CachePut,@CacheEvict,@Cacheable其缓存名都是
        // CachePut,@CacheEvict,@Cacheable中的cacheNames（即value）值+“:”+key
        // 因为本示例中使用了kryo对象作为redis的对象序列化的工具所以
        // 对cacheName:key要使用序列化，先将“cacheNames:”的值序列化，再对key进行序列化，
        // 将这两部分的byte数组合并起来做为key
        RedisSerializer serializer = redisTemplate.getKeySerializer();
        byte[] idBytes = serializer.serialize(id);
        byte[] prefixBytes = (RedisConst.PERSON_CACHE_NAME + ":").getBytes();
        byte[] key = new byte[prefixBytes.length + idBytes.length];
        System.arraycopy(prefixBytes, 0, key, 0, prefixBytes.length);
        System.arraycopy(idBytes, 0, key, prefixBytes.length, idBytes.length);

        System.out.println(new String(key));
        return key;
    }

    /**
     * 删除redis中的对象
     *
     * @param t
     */
    public <T> void delete(T t) {
        getConnection().del(getKey(t));
    }

    /**
     * 更新缓存中的对象，也可以在redis缓存中存入新的对象
     *
     * @param id
     * @param t
     * @param <T>
     */
    public <T> void set(Long id, T t) {
        byte[] key = getKey(id);
        RedisSerializer serializer = redisTemplate.getValueSerializer();
        byte[] val = serializer.serialize(t);
        getConnection().set(key, val);

    }

    /**
     * 从缓存中取对象
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T> T getObject(Long id) {
        byte[] key = getKey(id);
        byte[] result = getConnection().get(key);
        return (T) redisTemplate.getValueSerializer().deserialize(result);
    }


}
