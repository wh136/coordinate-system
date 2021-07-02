package com.wh136.xyz.common.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

public abstract class BaseRedisCache {

    @Resource
    protected RedisTemplate<String, Object> redisTemplate;

    public <T> T getValueByKeyField(String key) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return (T) valueOperations.get(key);
    }

}
