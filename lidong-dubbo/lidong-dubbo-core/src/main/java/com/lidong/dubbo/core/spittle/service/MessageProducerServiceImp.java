package com.lidong.dubbo.core.spittle.service;

import com.lidong.dubbo.api.spittle.service.IMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private RabbitTemplate rabbitTemplate;

    @Resource
    private RabbitTemplate rabbitTemplate2;

    @Override
    public void sendMessage(Object message) {
        logger.info("to send message:{}",message);

        rabbitTemplate.convertAndSend("queueTestKey", message, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                return message;
            }
        });
        final int xdelay= 300*1000;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //发送延迟消息
        rabbitTemplate2.convertAndSend("order.delay.notify", message,
                new MessagePostProcessor() {

                    @Override
                    public Message postProcessMessage(Message message)
                            throws AmqpException {
                        //设置消息持久化
                        message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                        //设置延迟时间（5分钟后执行）
                        message.getMessageProperties().setDelay(xdelay);
                        logger.info("----"+sf.format(new Date()) + " Delay sent.");

                        return message;
                    }
                });
    }




}
