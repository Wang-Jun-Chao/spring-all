package com.example.spring.boot.redis;

import com.example.spring.boot.redis.aspect.RedisCacheAspect;
import com.example.spring.boot.redis.common.KryoRedisSerializer;
import com.example.spring.boot.redis.common.RedisClient;
import com.example.spring.boot.redis.common.RedisClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;


/**
 * Author: 王俊超
 * Date: 2017-05-07 10:02
 * All Rights Reserved !!!
 */
@Configuration
public class AppConfig {


    /**
     * Redis连接工厂
     *
     * @return
     */
    @Primary
    @Bean("redisConnectionFactory")
    public RedisConnectionFactory redisConnectionFactory() {

        // Redis集群地址
        List<String> clusterNodes = Arrays.asList("192.168.241.150:7110",
                "192.168.241.150:7111", "192.168.241.150:7112", "192.168.241.150:7113",
                "192.168.241.150:7114", "192.168.241.150:7115", "192.168.241.150:7116",
                "192.168.241.150:7117", "192.168.241.150:7118", "192.168.241.150:7119"
        );

        // 获取Redis集群配置信息
        RedisClusterConfiguration rcf = new RedisClusterConfiguration(clusterNodes);
        return new JedisConnectionFactory(rcf);
    }

    /**
     * 创建redis模板
     *
     * @param factory
     * @return
     * @throws UnknownHostException
     */
    @Primary
    @Bean("redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory)
            throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // 可根据需要设置
//        // redis value使用的序列化器
//        template.setValueSerializer(new KryoRedisSerializer<>());
//        template.setHashKeySerializer(new KryoRedisSerializer<>());
//        // redis key使用的序列化器
//        template.setKeySerializer(new KryoRedisSerializer<>());
//        template.setHashValueSerializer(new KryoRedisSerializer<>());

        template.afterPropertiesSet();
        return template;
    }

    /**
     * 返回redis客户端
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public RedisClient redisClient(RedisTemplate<Object, Object> redisTemplate) {
        RedisClientImpl redisClient = new RedisClientImpl();
        redisClient.setRedisTemplate(redisTemplate);
        KryoRedisSerializer<Object> serializer = new KryoRedisSerializer<>();
        redisClient.setKeySerializer(serializer);
        redisClient.setValSerializer(serializer);

        return redisClient;
    }

    /**
     * redis缓存的切面
     * @param redisClient
     * @return
     */
    @Bean
    public RedisCacheAspect redisCacheAspect(RedisClient redisClient) {
        RedisCacheAspect aspect = new RedisCacheAspect();
        aspect.setRedisClient(redisClient);
        return aspect;
    }
}
