package com.lidong.dubbo.core.util.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
/**
 * @项目名称:lidong-dubbo
 * @类名:MessageConsumer
 * @类的描述: RabbitMQ 消息消费者
 * @作者:lidong
 * @创建时间:2017/2/4 上午9:33
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
public class MessageConsumer implements MessageListener {

	private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

	@Override
	public void onMessage(Message message) {
		logger.info("------消费者处理消息------");
		logger.info("receive message",message);
	}

}