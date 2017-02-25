package com.lidong.dubbo.core.util.customer;

import com.rabbitmq.client.Channel;
import org.activiti.engine.impl.util.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

/**
 * @项目名称:lidong-dubbo
 * @类名:OrderConsumer
 * @类的描述:
 * @作者:lidong
 * @创建时间:2017/2/25 下午12:59
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
public class OrderConsumer implements ChannelAwareMessageListener {


    private Logger logger = LoggerFactory.getLogger(OrderConsumer.class);



    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        logger.info("[延时消息]" + message.getMessageProperties());
        if (message != null) {
            long deliveryTag = message.getMessageProperties().getDeliveryTag();
            logger.debug("deliveryTag= "+deliveryTag);
            //手动确认
            channel.basicAck(deliveryTag,false);

        }

    }
}
