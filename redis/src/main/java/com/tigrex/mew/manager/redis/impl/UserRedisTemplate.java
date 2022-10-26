package com.tigrex.mew.manager.redis.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tigrex.mew.entity.po.redis.User;
import com.tigrex.mew.manager.redis.AbstractRedisTemplate;
import com.tigrex.mew.manager.redis.UserRedis;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import java.time.Duration;

/**
 * redis template
 * @author linus
 */
@Repository(value = "userRedis")
public class UserRedisTemplate extends AbstractRedisTemplate<User> implements InitializingBean, UserRedis {

    @Autowired
    @Lazy
    private UserRedisTemplate template;

    @Override
    @Bean(value = "userRedisCacheManager")
    public CacheManager cacheManager() {
        Jackson2JsonRedisSerializer<User> serializer = getSerializer();
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues().entryTtl(Duration.ofSeconds(3600L))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        return new RedisCacheManager(redisCacheWriter, cacheConfiguration);
    }

    @Override
    public void afterPropertiesSet() {
        Jackson2JsonRedisSerializer<User> serializer = getSerializer();
        setConnectionFactory(redisConnectionFactory);
        setKeySerializer(new StringRedisSerializer());
        setValueSerializer(serializer);
        setHashKeySerializer(new StringRedisSerializer());
        setHashValueSerializer(serializer);
        super.afterPropertiesSet();
    }

    @Override
    public Jackson2JsonRedisSerializer<User> getSerializer() {
        Jackson2JsonRedisSerializer<User> serializer = new Jackson2JsonRedisSerializer<>(User.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        serializer.setObjectMapper(objectMapper);
        return serializer;
    }

    @Override
    public void insert(String key, User entity) {
        template.opsForValue().set(key, entity);
    }

    @Override
    public boolean deleteByKey(String key) {
        return template.deleteByKey(key);
    }

    @Override
    public void updateByKey(String key, User entity) {
        template.opsForValue().set(key, entity);
    }

    @Override
    public User selectByKey(String key) {
        return template.opsForValue().get(key);
    }
}
