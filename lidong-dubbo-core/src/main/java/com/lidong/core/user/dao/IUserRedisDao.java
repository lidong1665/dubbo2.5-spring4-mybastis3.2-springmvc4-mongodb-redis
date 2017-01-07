package com.lidong.core.user.dao;

import java.util.List;

import com.lidong.model.user.User;

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
    public User findById(String key); 
    /**
     * 
     * @param user
     */
    public void  saveUser(String key,User user); 
    
    /**
     * 
     * @param user
     */
    public List<User>   getUserList(String key,long start,long end); 
    
    /**
     * 
     * @param key
     * @param user
     * @return
     */
    public Long   addUserToUserList(String key,User user); 
    
    

}
