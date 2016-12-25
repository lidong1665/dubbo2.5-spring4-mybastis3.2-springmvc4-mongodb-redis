package com.lidong.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
/**
 * 
 * @author Administrator
 *
 * @param <String>
 * @param <Object>
 */
public abstract class AbstractBaseRedisTemplete implements
		ApplicationContextAware {
	
	
	protected RedisTemplate<String,Object>  redisTemplate;
	
	 /** 
     * @Description RedisTemplate 
     * @param redisTemplate 
     */  
    public void setRedisTemplate(RedisTemplate<String,Object> redisTemplate) {  
        this.redisTemplate = redisTemplate;  
    }  
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		@SuppressWarnings("unchecked")
		RedisTemplate<String,Object> redisTemplate = applicationContext.getBean(  
                "redisTemplate", RedisTemplate.class);  
		setRedisTemplate(redisTemplate); 

	}

}
