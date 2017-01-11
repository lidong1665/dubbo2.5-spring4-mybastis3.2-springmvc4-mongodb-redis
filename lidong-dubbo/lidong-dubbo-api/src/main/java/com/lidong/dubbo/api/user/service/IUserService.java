package com.lidong.dubbo.api.user.service;

import com.lidong.dubbo.model.user.User;

import java.util.List;

/**
 * @className :IUserService
 * @desc      :
 * @author    :lidong
 * @createTime:2017/1/8 下午8:35
 * @company   :chni
 * @QQ        :1561281670
 * @email     :lidong1665@163.com
 */
public interface IUserService {

    String sayHello(String name)throws Exception;

    /**
     * 根据用户id查找用户
     * @param userId
     * @return
     */

    User getUserById(int userId)throws Exception;
    /**
     * 根据用户username查找用户
     * @param username
     * @return
     */
    User getUserByUsername(String username)throws Exception;
    /**
     * 添加用户
     * @param user
     * @return
     */
    void addUser(User user);
    /**
     * 查找所有的客户
     * @return
     */
    List<User> getAllUser() throws Exception;
    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    int delUserById(Integer userId)throws Exception;

    /**
     * 添加用户
     * @param user
     * @return
     */
    int updateUser(User user)throws Exception;
}
