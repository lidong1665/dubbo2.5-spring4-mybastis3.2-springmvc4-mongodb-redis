package com.lidong.dubbo.core.util.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.jms.*;

/**
 * @项目名称:lidong-dubbo
 * @类名:SpittleAlertHandler
 * @类的描述:
 * @作者:lidong
 * @创建时间:2017/1/27 下午1:43
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
@Component
@MessageDriven
public class SpittleAlertHandler implements MessageListener{

    private Logger logger = LoggerFactory.getLogger(SpittleAlertHandler.class);


    @Override
    public void onMessage(Message message) {
        logger.info("-----------消费者处理消息------------");
        logger.info("接收到一个自定义消息。"+message.toString());
        if (message instanceof TextMessage) {
            TextMessage objMessage = (TextMessage) message;
            try {
                System.out.println("消息类型是：" + objMessage.getJMSType());
                System.out.println("消息id是：" + objMessage.getJMSMessageID());
                System.out.println("消息内容是：" + objMessage.getText());

            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
