package com.lidong.core.user.dao;

import java.util.List;

import com.lidong.model.user.UserInfo;


public interface IUserMongDBDao {
	 /** 
     * ������������������ 
     *  
     * @author���lidong 
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
    public UserInfo findById(String id); 
    /** 
     *  
     * @Title: findAll 
     * @param @return 
     * @return List<UserModel> 
     * @date May 13, 2016 3:07:39 PM 
     * @throws 
     */  
    public List<UserInfo> findByState(String state ); 
    
    
    
    /** 
     *  
     * @Title: updateUser 
     * @Description: TODO 
     * @param @param user 
     * @date May 13, 2016 3:11:12 PM 
     * @throws 
     */  
    public void updateUser(UserInfo user);
    
    /**
     * @param user
     */
    public void insertUser(UserInfo user);
    
  
	/**
	 * 
	 * @Title: removeUser
	 * @Description: TODO
	 * @param @param userName
	 * @date May 13, 2016 3:11:01 PM
	 * @throws
	 */
    public void removeUser(String userName);
}
