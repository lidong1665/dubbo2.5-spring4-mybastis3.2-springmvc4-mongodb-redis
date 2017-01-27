package com.lidong.dubbo.core.spittle.service;

import com.lidong.dubbo.api.spittle.service.IAlertService;
import com.lidong.dubbo.model.user.User;
import com.lidong.dubbo.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @项目名称:lidong-dubbo
 * @类名:AlertSpittleServiceImp
 * @类的描述:
 * @作者:lidong
 * @创建时间:2017/1/27 下午1:25
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
@Service
public class AlertSpittleServiceImp implements IAlertService {


    private Logger logger = LoggerFactory.getLogger(AlertSpittleServiceImp.class);


    private JmsTemplate jmsTemplate;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }
    @Resource
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }



    /**
     * 发送消息
     *
     * @param user
     */
    @Override
    public void sendSpittleAlert(final User user) {
        logger.info("----------生产者发送消息-------------");
        jmsTemplate.send("spittle.alert.queue", new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(user.getName());
            }
        });

    }
}
