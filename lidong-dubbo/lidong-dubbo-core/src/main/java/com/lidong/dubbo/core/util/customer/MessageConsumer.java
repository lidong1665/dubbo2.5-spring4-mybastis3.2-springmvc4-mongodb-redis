package com.lidong.dubbo.core.util.customer;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

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
public class MessageConsumer implements ChannelAwareMessageListener {

	private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

	/**
	 * @param message  （消息实体）
	 * @param channel   (channel就是当前的通道)
	 * @throws Exception
	 * 备注：
	 * 手动ack就是在当前channel里面调用basicAsk的方法，并传入当前消息的tagId就可以了。
	 */
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		logger.info("------消费者处理消息------");
		logger.info("receive message"+message.getMessageProperties().getAppId());
		logger.info("receive channel"+channel.getChannelNumber()+"----");
		long deliveryTag = message.getMessageProperties().getDeliveryTag();
        logger.debug("#########"+deliveryTag);
		//消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息
		channel.basicAck(deliveryTag, false);
		// ack返回false，并重新回到队列
//		channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
		// 拒绝消息
//		channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
	}
}