package com.lidong.dubbo.core.user.dao;

import com.lidong.dubbo.model.user.User;

import java.util.List;
/**
 * @项目名称:lidong-dubbo
 * @类名:IUserDao
 * @类的描述:
 * @作者:lidong
 * @创建时间:2017/1/9 上午9:36
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
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
     * @param username
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
