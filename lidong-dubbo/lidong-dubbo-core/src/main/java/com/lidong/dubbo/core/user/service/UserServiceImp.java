package com.lidong.dubbo.core.user.service;

import com.lidong.dubbo.api.user.service.IUserService;
import com.lidong.dubbo.model.user.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.lidong.dubbo.core.user.dao.IUserDao;

import java.util.List;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImp implements IUserService {

	@Resource
	IUserDao mIUserDao;

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}
	@Cacheable(value={"getUserById"})
	@Override
	public User getUserById(int userId) {
		return mIUserDao.selectByPrimaryKey(userId);
	}

	@Override
	public User getUserByUsername(String username) {
		return mIUserDao.selectByPrimaryUsername(username);
	}

	@CacheEvict(value={"getAllUser"},allEntries=true)
	@Override
	public void addUser(User user) {
		mIUserDao.insert(user);
	}

	@Cacheable(value={"getAllUser"})
	@Override
	public List<User> getAllUser() {
		return mIUserDao.selectAllUsers();
	}

	@CacheEvict(value={"getAllUser","getUserById"},allEntries=true)
	@Override
	public int delUserById(Integer userId) {
		return mIUserDao.deleteByPrimaryKey(userId);
	}

	@CacheEvict(value={"getAllUser","getUserById"},allEntries=true)
	@Override
	public int updateUser(User user) {
		return mIUserDao.updateByPrimaryKey(user);
	}
}
