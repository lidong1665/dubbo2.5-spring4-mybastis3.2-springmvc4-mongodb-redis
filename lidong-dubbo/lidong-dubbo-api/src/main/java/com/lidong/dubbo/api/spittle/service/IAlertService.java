package com.lidong.dubbo.api.spittle.service;

import com.lidong.dubbo.model.user.User;

import javax.jms.JMSException;

/**
 * @项目名称:lidong-dubbo
 * @类名:AlertService
 * @类的描述:
 * @作者:lidong
 * @创建时间:2017/1/25 下午5:27
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
public interface IAlertService {
    /**
     *发送消息
     */
    void sendSpittleAlert(User user);

}
