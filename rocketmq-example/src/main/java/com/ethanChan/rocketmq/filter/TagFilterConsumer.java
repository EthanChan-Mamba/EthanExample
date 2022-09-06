package com.ethanChan.rocketmq.filter;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName TagFilterProducer.java
 * @Description 只消费TagA||TagB的消息
 * @createTime 2022-08-22 17:17
 */
public class TagFilterConsumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("TagFilterConsumer");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.subscribe("TagFilterTest", "TagA||TagB");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                try {
                    for (MessageExt msg : msgs) {
                        String topic = msg.getTopic();
                        String msgBody = new String(msg.getBody(), StandardCharsets.UTF_8);
                        String msgPro = msg.getProperty("a");
                        String tags = msg.getTags();
                        System.out.println("收到消息: " + " topic: " + topic + " , tags: " + tags
                                + " ,a: " + msgPro + " ,msg: " + msgBody);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    // 这个点注意: 意思是要先等一会，一会再处理消息，而不是放到重试队列里
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("Consumer start");

    }
}
