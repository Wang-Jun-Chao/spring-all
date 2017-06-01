package com.example.spring.boot.redis.mapper;

import com.example.spring.boot.redis.entity.RedisConfig;

import java.util.List;

/**
 * Author: 王俊超
 * Date: 2017-05-07 09:50
 * All Rights Reserved !!!
 */

public interface RedisConfigMapper {

    /**
     * 获取Redis的配置信息
     *
     * @return
     */
    List<RedisConfig> getRedisConfig();
}
