package com.lidong.dubbo.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 基础的RedisTemplete
 * @author lidong
 * @param <T>
 * @date 2017-1-5
 */
public  class BaseRedisTemplete<T> {

	@Qualifier("redisTemplate")
	@Autowired
	protected RedisTemplate<String,T> redisTemplate;

}
