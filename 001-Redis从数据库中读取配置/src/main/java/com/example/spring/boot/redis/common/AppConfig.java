package com.example.spring.boot.redis.common;

import com.example.spring.boot.redis.entity.RedisConfig;
import com.example.spring.boot.redis.mapper.RedisConfigMapper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.sql.DataSource;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


/**
 * Author: 王俊超
 * Date: 2017-05-07 10:02
 * All Rights Reserved !!!
 */
@Configuration

@MapperScan(basePackages = "com.example.spring.boot.redis.mapper")
public class AppConfig {


    /**
     * 设置mybatis会话工厂
     * @param ds
     * @return
     * @throws Exception
     */
    @Primary
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(ds);

        // 设置mybatis xml文件扫描路径
        factory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/*Mapper.xml"));
        return factory.getObject();
    }

    /**
     * Redis连接工厂
     * @param mapper 这个非常重要，必须在mapper被创建了之后才能创建Redis连接工厂
     * @return
     */
    @Primary
    @Bean("redisConnectionFactory")
    public RedisConnectionFactory redisConnectionFactory(RedisConfigMapper mapper) {

        // 获取redis连接信息
        List<RedisConfig> redisConfigs = mapper.getRedisConfig();
        List<String> clusterNodes = new ArrayList<>();
        for (RedisConfig rc : redisConfigs) {
            clusterNodes.add(rc.getUrl() + ":" + rc.getPort());
        }

        // 获取Redis集群配置信息
        RedisClusterConfiguration rcf = new RedisClusterConfiguration(clusterNodes);

        return new JedisConnectionFactory(rcf);
    }

    /**
     * 创建redis模板
     *
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Primary
    @Bean("redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        // redis value使用的序列化器
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // redis key使用的序列化器
        template.setKeySerializer(jackson2JsonRedisSerializer);


        template.afterPropertiesSet();
        return template;
    }
}
