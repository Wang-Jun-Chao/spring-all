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

    /**
     * 获取最终的key
     *
     * @param cacheName
     * @param key
     * @return
     */
    private byte[] getRealKey(Object cacheName, Object key) {
        byte[] b1 = keySerializer.serialize(cacheName);
        byte[] b2 = keySerializer.serialize(key);
        byte[] result = new byte[b1.length + b2.length];
        System.arraycopy(b1, 0, result, 0, b1.length);
        System.arraycopy(b2, 0, result, b1.length, b2.length);
        return result;
    }

    /**
     * 获取真实key
     * @param cacheName
     * @param key
     * @return
     */
    private byte[] getRealKey(byte[] cacheName, Object key) {
        byte[] b2 = keySerializer.serialize(key);
        byte[] result = new byte[cacheName.length + b2.length];
        System.arraycopy(cacheName, 0, result, 0, cacheName.length);
        System.arraycopy(b2, 0, result, cacheName.length, b2.length);

        return result;
    }


    @Override
    public long del(Object cacheName, Object... keys) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] b1 = keySerializer.serialize(cacheName);
                long result = 0;
                for (Object o : keys) {
                    result += connection.del(getRealKey(b1, o));
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
    public void set(Object cacheName, Object key, Object value, long liveTime) {
        this.set(getRealKey(cacheName, key), valSerializer.serialize(value), liveTime);
    }

    @Override
    public void set(Object cacheName, Object key, Object value) {
        this.set(cacheName, key, value, 0L);
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
    public <T> T get(byte[] key) {
        return redisTemplate.execute(new RedisCallback<T>() {
            @Override
            public T doInRedis(RedisConnection connection) throws DataAccessException {
                Object obj = valSerializer.deserialize(connection.get(key));
                return (T) obj;
            }
        });
    }

    @Override
    public <T> T get(Object cacheName, Object key) {
        return this.get(getRealKey(cacheName, key));
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
        return this.keys(keySerializer.serialize(pattern));
    }

    @Override
    public boolean exists(byte[] key) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key);
            }
        });
    }

    @Override
    public boolean exists(Object cacheName, Object key) {
        return this.exists(getRealKey(cacheName, key));
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
}
