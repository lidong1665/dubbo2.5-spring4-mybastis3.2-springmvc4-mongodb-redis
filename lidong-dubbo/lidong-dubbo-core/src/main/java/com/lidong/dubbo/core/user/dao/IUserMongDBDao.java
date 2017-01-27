package com.lidong.dubbo.core.user.dao;

import com.lidong.dubbo.model.user.UserInfo;

import java.util.List;




public interface IUserMongDBDao {
	 /** 
     *  
     *  
     * @author lidong 
     * @Title: findAll 
     * @param @return 
     * @return List<UserModel> 
     * @date May 13, 2016 3:07:39 PM 
     * @throws 
     */  
    public List<UserInfo> findAll();
    
    /** 
     *  
     * @Title: findAll 
     * @param @return 
     * @return List<UserModel> 
     * @date May 13, 2016 3:07:39 PM 
     * @throws 
     */  
     UserInfo findById(String id);
    /** 
     *  
     * @Title: findAll 
     * @param @return 
     * @return List<UserModel> 
     * @date May 13, 2016 3:07:39 PM 
     * @throws 
     */  
     List<UserInfo> findByState(String state);
    
    
    
    /** 
     *  
     * @Title: updateUser 
     * @Description: TODO 
     * @param @param user 
     * @date May 13, 2016 3:11:12 PM 
     * @throws 
     */  
     void updateUser(UserInfo user);
    
    /**
     * @param user
     */
     void insertUser(UserInfo user);
    
  
	/**
	 * 
	 * @Title: removeUser
	 * @Description: TODO
	 * @param @param userName
	 * @date May 13, 2016 3:11:01 PM
	 * @throws
	 */
     void removeUser(String userName);
}
