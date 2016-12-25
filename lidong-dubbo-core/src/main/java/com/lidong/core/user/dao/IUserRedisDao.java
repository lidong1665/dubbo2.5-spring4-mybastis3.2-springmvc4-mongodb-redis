package com.lidong.core.user.dao;

public interface IUserRedisDao {

	
	 /** 
     * 查询数据 
     *  
     * @author：lidogn 
     * @Title: findAll 
     * @param @return 
     * @return List<UserModel> 
     * @date May 13, 2016 3:07:39 PM 
     * @throws 
     */  
    public String findById(String key); 
}
