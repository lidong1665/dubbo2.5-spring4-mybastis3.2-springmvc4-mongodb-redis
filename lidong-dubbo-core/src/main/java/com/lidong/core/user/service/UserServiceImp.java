package com.lidong.core.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lidong.api.service.user.IUserService;
import com.lidong.core.user.dao.IUserDao;
import com.lidong.model.user.User;
@Service("userService")
public class UserServiceImp implements IUserService {

	@Resource
	IUserDao mIUserDao;
	
	@Override
	public String sayHello(String name) {
		
		  return "Hello " + name;  
	}

	@Override
	public User getUserById(int userId) {
		return mIUserDao.selectByPrimaryKey(userId);
	}

	@Override
	public User getUserByUsername(String username) {
		return mIUserDao.selectByPrimaryUsername(username);
	}

	@Override
	public void addUser(User user) {
	    mIUserDao.insert(user);
	}

	@Override
	public List<User> getAllUser() {
		return mIUserDao.selectAllUsers();
	}

	@Override
	public int delUserById(Integer userId) {
		return mIUserDao.deleteByPrimaryKey(userId);
	}

	@Override
	public int updateUser(User user) {
		return mIUserDao.updateByPrimaryKey(user);
	}

}
