package com.ethan.rocketmqTransactionExample.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息订阅配置
 */
@Component
@Slf4j
public class RocketMqConsumer {

    @Autowired
    private ConsumeListenerImpl consumeListener;
    @Autowired
    private DefaultMQPushConsumer transactionMQConsumer;

    /**
     * TCPMessage消费
     */
    public void startRiskServiceTCP() throws MQClientException {

        transactionMQConsumer.subscribe("risk_top", "*");
        transactionMQConsumer.setMessageListener(consumeListener);
        transactionMQConsumer.start();
    }

}
