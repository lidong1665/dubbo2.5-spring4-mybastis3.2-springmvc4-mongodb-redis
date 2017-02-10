package com.lidong.dubbo.core.user.dao;

import com.lidong.dubbo.core.util.BaseRedisTemplete;
import com.lidong.dubbo.model.user.User;

import java.util.List;

public class UserRedisDaoImp extends BaseRedisTemplete<User>
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
