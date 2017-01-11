package com.lidong.dubbo.core.util;


import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
/**
 * RedisCachingConfig Redis 配置缓存key的规则
 * @author lidong
 * @version 1.0.0
 */
@Configuration
@EnableCaching
public class RedisCachingConfig extends CachingConfigurerSupport{
	
	@Bean 
	@Override
    public KeyGenerator keyGenerator(){  
        return new KeyGenerator() {

			@Override
			public Object generate(Object target, Method method,
					Object... params) {
				StringBuilder sb = new StringBuilder();  
                sb.append(target.getClass().getName());  
                sb.append(method.getName());  
                for (Object obj : params) {  
                    sb.append(obj.toString());  
                }  
                return sb.toString(); 
			}  
            
        };  
  
    }
}
