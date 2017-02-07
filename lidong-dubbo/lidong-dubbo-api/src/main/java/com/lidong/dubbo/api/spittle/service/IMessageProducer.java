package com.lidong.dubbo.api.spittle.service;

/**
 * @项目名称:lidong-dubbo
 * @类名:IMessageProducer
 * @类的描述:
 * @作者:lidong
 * @创建时间:2017/2/4 上午9:34
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
public interface IMessageProducer {
    /**
     * 发送消息
     * @param message
     */
     void sendMessage(Object message);



}
