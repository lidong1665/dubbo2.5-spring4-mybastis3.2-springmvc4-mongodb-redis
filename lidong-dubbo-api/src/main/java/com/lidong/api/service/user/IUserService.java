package com.lidong.api.service.user;

import java.util.List;

import com.lidong.model.user.User;


public interface IUserService {

	     String sayHello(String name);  
	
	    /**
		 * 根据用户id查找用户
		 * @param userId
		 * @return
		 */
	     User getUserById(int userId);  
	    /**
	     * 根据用户username查找用户
	     * @param username
	     * @return
	     */
	     User getUserByUsername(String username);
	    /**
	     * 添加用户
	     * @param username
	     * @return
	     */
		 void addUser(User user);
		/**
		 * 查找所有的客户
		 * @return
		 */
		 List<User> getAllUser();  
		/**
		 * 根据用户id删除用户
		 * @param userId
		 * @return
		 */
	     int delUserById(Integer userId);
	    
	    /**
	     * 添加用户
	     * @param username
	     * @return
	     */
		 int updateUser(User user);
}
