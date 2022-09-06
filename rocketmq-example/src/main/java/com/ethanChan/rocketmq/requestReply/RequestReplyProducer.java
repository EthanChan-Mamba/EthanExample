package com.ethanChan.rocketmq.requestReply;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName RequestReplyProducer.java
 * @Description 生产者向RequestTopic主题发送RPC消息，使用同步阻塞方式
 * @createTime 2022-08-23 14:12
 */
public class RequestReplyProducer {
    public static void main(String[] args) throws MQClientException {
        String producerGroup = "RPC";
        String topic = "RequestTopic";
        // 超时时间
        long ttl = 3000;

        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr("127.0.0..1:9876");
        producer.start();

        try {
            Message message = new Message(topic, "", "Hello World".getBytes(RemotingHelper.DEFAULT_CHARSET));
            long begin = System.currentTimeMillis();
            Message retMsg = producer.request(message, ttl);
            long cost = System.currentTimeMillis() - begin;
            System.out.printf("request to <%s> cost: %dms replymessage: %s %n", topic, cost, retMsg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        producer.shutdown();

    }
}
