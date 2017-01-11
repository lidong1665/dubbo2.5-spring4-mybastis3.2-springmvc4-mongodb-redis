package com.lidong.dubbo.api.login.service;

import java.util.Map;

/**
 * @className :ILoginService
 * @desc      :
 * @author    :lidong
 * @createTime:2017/1/8 下午8:32
 * @company   :chni
 * @QQ        :1561281670
 * @email     :lidong1665@163.com
 */
public interface ILoginService {

    /**
     * 登录
     * @param map
     * @return
     * @throws Exception
     * @author    :lidong
     * @createTime:2017/1/8 下午8:32
     * @company   :chni
     * @QQ        :1561281670
     * @email     :lidong1665@163.com
     */
    Map<String,Object> login(Map<String,Object> map)throws Exception;
}
