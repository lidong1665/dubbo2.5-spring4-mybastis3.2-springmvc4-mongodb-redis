package com.lidong.dubbo.core.user.dao;

import com.lidong.dubbo.model.user.User;

import java.util.List;


public interface IUserRedisDao {

	
	 /** 
     * 查询数据 
     *  
     * @author：lidogn 
     * @Title: findById 
     * @param @return 
     * @return List<UserModel> 
     * @date May 13, 2016 3:07:39 PM 
     * @throws 
     */  
     User findById(String key);
    /**
     * 
     * @param user
     */
     void  saveUser(String key, User user);

    /**
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
     List<User>   getUserList(String key, long start, long end);
    
    /**
     * 
     * @param key
     * @param user
     * @return
     */
     Long   addUserToUserList(String key, User user);
    
    

}
