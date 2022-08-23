package com.chen.rocketmq.filter;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName TagFilterProducer.java
 * @Description 只消费TagA||TagB的消息
 * @createTime 2022-08-22 17:17
 */
public class SqlFilterConsumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("SqlFilterConsumer");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.subscribe("SqlFilterTest",
                MessageSelector.bySql("TAGS is not null and TAGS in ('TagA', 'TagB')) " +
                            "and (a is not null and a between 0 and 3)"));
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
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
        });
        consumer.start();
        System.out.println("Consumer start");

    }
}
