package com.lidong.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
/**
 * 基础的RedisTemplete
 * @author lidong
 * @param <T>
 * @date 2017-1-5
 */
public abstract class AbstractBaseRedisTemplete<T> implements
		ApplicationContextAware {
	
	
	protected RedisTemplate<String,T>  redisTemplate;
	
	 /** 
     * @Description RedisTemplate 
     * @param redisTemplate 
     */  
    public void setRedisTemplate(RedisTemplate<String,T> redisTemplate) {  
        this.redisTemplate = redisTemplate;  
    }  
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		@SuppressWarnings("unchecked")
		RedisTemplate<String,T> redisTemplate = applicationContext.getBean(  
                "redisTemplate", RedisTemplate.class);  
		setRedisTemplate(redisTemplate); 
	}

}
