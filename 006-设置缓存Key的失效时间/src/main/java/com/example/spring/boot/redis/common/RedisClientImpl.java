package com.example.spring.boot.redis.common;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.Set;


/**
 * Author: 王俊超
 * Date: 2017-06-04 19:57
 * All Rights Reserved !!!
 */

public class RedisClientImpl implements RedisClient {
    private RedisTemplate<Object, Object> redisTemplate;
    private RedisSerializer<Object> keySerializer;
    private RedisSerializer<Object> valSerializer;


    public RedisTemplate<Object, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisSerializer<Object> getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(RedisSerializer<Object> keySerializer) {
        this.keySerializer = keySerializer;
    }

    public RedisSerializer<Object> getValSerializer() {
        return valSerializer;
    }

    public void setValSerializer(RedisSerializer<Object> valSerializer) {
        this.valSerializer = valSerializer;
    }

    /////////////////////////////////////

    @Override
    public long del(Object... keys) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                long result = 0;
                for (Object o : keys) {
                    result += connection.del(keySerializer.serialize(keys));
                }
                return result;
            }
        });
    }

    @Override
    public void set(byte[] key, byte[] value, long liveTime) {
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(key, value);
                if (liveTime > 0) {
                    connection.expire(key, liveTime);
                }

                return true;
            }
        });
    }

    @Override
    public void set(Object key, Object value, long liveTime) {
        this.set(keySerializer.serialize(key), valSerializer.serialize(value), liveTime);
    }

    @Override
    public void set(Object key, Object value) {
        this.set(key, value, 0L);
    }

    @Override
    public void set(byte[] key, byte[] value) {
        this.set(key, value, 0L);
    }

    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */

    @Override
    public  <T> T get(byte[] key) {
        return redisTemplate.execute(new RedisCallback<T>() {
            @Override
            public T doInRedis(RedisConnection connection) throws DataAccessException {
                Object obj = valSerializer.deserialize(connection.get(key));
                return (T) obj;
            }
        });
    }

    @Override
    public <T> T get(Object key) {
       return  this.get(keySerializer.serialize(key));
    }
    @Override
    public Set keys(byte[] pattern) {
        return redisTemplate.execute(new RedisCallback<Set>() {
            @Override
            public Set doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.keys(pattern);
            }
        });
    }

    @Override
    public Set keys(String pattern) {
       return  this.keys(keySerializer.serialize(pattern));
    }
    @Override
    public boolean exists(byte[] key){
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key);
            }
        });
    }
    @Override
    public boolean exists(Object key) {
        return this.exists(valSerializer.serialize(key));
    }

    @Override
    public boolean flushDb() {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return true;
            }
        });
    }

    @Override
    public long dbSize() {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.dbSize();
            }
        });
    }

    @Override
    public String ping() {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.ping();
            }
        });
    }
    //    /**
//     * 取redis连接
//     *
//     * @return
//     */
//    private RedisConnection getConnection() {
//        return redisTemplate.getConnectionFactory().getConnection();
//    }
//
//    /**
//     * 获取缓存的key
//     *
//     * @param key
//     * @return
//     */
//    private byte[] getKey(String cacheName, String key) {
//        return (cacheName+":" + key).getBytes();
//    }
//
//    /**
//     * 删除redis中的对象
//     *
//     * @param cacheName
//     * @param key
//     */
//    public <T> void delete(String cacheName, String key) {
//        getConnection().del(getKey(cacheName, key));
//    }
//
//    /**
//     * 更新缓存中的对象，也可以在redis缓存中存入新的对象
//     *
//     * @param cacheName
//     * @param key
//     * @param t
//     * @param <T>
//     */
//    public <T> void set(String cacheName, String key, T t) {
//        byte[] keyBytes = getKey(cacheName, key);
//        RedisSerializer serializer = redisTemplate.getValueSerializer();
//        byte[] val = serializer.serialize(t);
//        getConnection().set(keyBytes, val);
//
//    }
//
//    /**
//     * 从缓存中取对象
//     *
//     * @param key
//     * @param <T>
//     * @return
//     */
//    public <T> T getObject(String cacheName, String key) {
//        byte[] keyBytes = getKey(cacheName, key);
//        byte[] result = getConnection().get(keyBytes);
//        return (T) redisTemplate.getValueSerializer().deserialize(result);
//    }


}
