package com.lidong.core.user.dao;

import java.util.List;
import java.util.Set;

import com.lidong.model.user.User;
import com.lidong.util.AbstractBaseRedisTemplete;

public class UserRedisDaoImp extends AbstractBaseRedisTemplete<User> 
              implements IUserRedisDao {

	
	
	@Override
	public User findById(String key) {
		return (User) redisTemplate.opsForValue().get(key);
	}

	@Override
	public void saveUser(String key,User user) {
		 redisTemplate.opsForValue().set(key, user);
		 
	}

	@Override
	public List<User> getUserList(String key,long start,long end) {
		 return  redisTemplate.opsForList().range(key, 0, end);
	}

	@Override
	public Long addUserToUserList(String key, User user) {
		return redisTemplate.opsForList().leftPush(key, user);
	  
	}

}
