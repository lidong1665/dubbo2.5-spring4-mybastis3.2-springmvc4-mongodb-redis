package com.lidong.core.user.dao;

import java.util.List;

import com.lidong.model.user.User;


/**
 * 
 * @author Administrator
 *
 */
public interface IUserDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);  
	/**
	 * @param record
	 * @return
	 */
    int insert(User record);  
  
    int insertSelective(User record);  
    /**
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);
    /**
     * @param name
     * @return  User
     */
    User selectByPrimaryUsername(String username);  
    /**
     * @return
     */
    List<User> selectAllUsers();
    
    
    int updateByPrimaryKeySelective(User record);  
  
    int updateByPrimaryKey(User record);  
}
