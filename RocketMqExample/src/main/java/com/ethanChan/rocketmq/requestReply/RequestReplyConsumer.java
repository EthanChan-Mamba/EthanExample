package com.ethanChan.rocketmq.requestReply;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.utils.MessageUtil;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName RequestReplyConsumer.java
 * @Description 消费者接受主题消息发送RPC响应。收到响应后需要再做一次生产，使用工具类MessageUtil封装消息后进行响应消息发送
 * @createTime 2022-08-23 14:36
 */
public class RequestReplyConsumer {
    public static void main(String[] args) throws MQClientException {
        String producerGroup = "rpc-p";
        String consumerGroup = "rpc-c";
        String topic = "RequestTopic";

        DefaultMQProducer replyProducer = new DefaultMQProducer(producerGroup);
        replyProducer.setNamesrvAddr("127.0.0.1:9876");
        replyProducer.start();

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.setPullTimeDelayMillsWhenException(0L);
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg : msgs) {
                    try {
                        String replyTo = MessageUtil.getReplyToClient(msg);
                        byte[] replyContent = "reply message contents.".getBytes();
                        Message replyMessage = MessageUtil.createReplyMessage(msg, replyContent);
                        SendResult replyResult = replyProducer.send(replyMessage, 3000);
                        System.out.printf("reply to %s , %s /n  ", replyTo, replyResult.toString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.subscribe(topic, "*");
        consumer.start();
    }
}
