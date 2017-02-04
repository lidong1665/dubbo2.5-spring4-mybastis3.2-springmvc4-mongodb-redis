package com.lidong.dubbo.core.spittle.service;

import com.lidong.dubbo.api.spittle.service.IMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @项目名称:lidong-dubbo
 * @类名:MessageProducerImp
 * @类的描述:
 * @作者:lidong
 * @创建时间:2017/2/4 上午10:01
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
@Service
public class MessageProducerServiceImp implements IMessageProducer {
    
    
    private Logger logger = LoggerFactory.getLogger(MessageProducerServiceImp.class);


    @Resource
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(Object message) {
        logger.info("to send message:{}",message);
        amqpTemplate.convertAndSend("queueTestKey",message);
    }
}
