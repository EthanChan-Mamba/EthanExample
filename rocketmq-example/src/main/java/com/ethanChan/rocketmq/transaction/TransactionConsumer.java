package com.ethanChan.rocketmq.transaction;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName TransactionConsumer.java
 * @Description TODO
 * @createTime 2022-08-23 13:54
 */
public class TransactionConsumer {
    public static void main(String[] args) throws Exception {
        // Instantiate message consumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("TransactionConsumer");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        // Subscribe topics
        consumer.subscribe("TransactionTopic", "*");
        consumer.setMessageModel(MessageModel.CLUSTERING);
        // Register message listener
        consumer.registerMessageListener((MessageListenerConcurrently) (messages, context) -> {
            try {
                // 开启事务
                for (MessageExt msg : messages) {
                    // 执行本地事务 update B...(幂等性)
                    System.out.println("update A ... where transactionId: " + msg.getTransactionId());
                    // 本地事务成功
                    System.out.println("commint: " + msg.getTransactionId());
                    System.out.println("执行本地事务成功, 确认消息");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("执行本地事务失败, 重试消费, 尽量确保B处理成功");
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        // Launch consumer
        consumer.start();
    }
}
