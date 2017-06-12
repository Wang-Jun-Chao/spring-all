package com.example.spring.boot.redis.common;

import java.util.Set;

/**
 * Author: 王俊超
 * Date: 2017-06-12 07:40
 * All Rights Reserved !!!
 */
public interface RedisClient {

    /**
     * 通过key删除
     *
     * @param keys
     */
    long del(Object... keys);

    /**
     * 添加key value 并且设置存活时间(byte)
     *
     * @param key
     * @param value
     * @param liveTime
     */
    void set(byte[] key, byte[] value, long liveTime);

    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime 单位秒
     */
    void set(Object key, Object value, long liveTime);

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    void set(Object key, Object value);

    /**
     * 添加key value (字节)(序列化)
     *
     * @param key
     * @param value
     */
    void set(byte[] key, byte[] value);

    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    <T> T get(byte[] key);

    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    <T> T get(Object key);

    /**
     * 通过正则匹配keys
     *
     * @param pattern
     * @return
     */
    Set keys(byte[] pattern);

    /**
     * 通过正则匹配keys
     *
     * @param pattern
     * @return
     */
    Set keys(String pattern);

    /**
     * 检查key是否已经存在
     *
     * @param key
     * @return
     */
    boolean exists(byte[] key);

    /**
     * 检查key是否已经存在
     *
     * @param key
     * @return
     */
    boolean exists(Object key);

    /**
     * 清空redis 所有数据
     *
     * @return
     */
    boolean flushDb();

    /**
     * 查看redis里有多少数据
     */
    long dbSize();

    /**
     * 检查是否连接成功
     *
     * @return
     */
    String ping();

}
