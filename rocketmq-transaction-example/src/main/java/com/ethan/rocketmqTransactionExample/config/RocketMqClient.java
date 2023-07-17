package com.ethan.rocketmqTransactionExample.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class RocketMqClient {

    @Autowired
    TransactionListenerImpl transactionListener;


    @Value(value = "${mqAd}")
    private String mqAd;

    private static ThreadPoolExecutor TRANSACTION_EXECUTOR =
            new ThreadPoolExecutor(5, 5, 10
                    , TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));

    /**
     * TCP链接
     *
     * @return
     */
    @Bean(value = "transactionMQProducer")
    public TransactionMQProducer createTransactionMQProducer() throws MQClientException {
        log.info("创建生产者");
        TransactionMQProducer producer = new TransactionMQProducer("testTranMq");
        // Specify name server addresses.
        producer.setNamesrvAddr(mqAd);
        producer.setTransactionListener(transactionListener);
        producer.setExecutorService(TRANSACTION_EXECUTOR);
        //Launch the instance.
        producer.start();
        //Wait for sending to complete
        return producer;
    }

    @Bean(value = "transactionMQConsumer")
    public DefaultMQPushConsumer consumerBean() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("testTranMq");

        // Specify name server addresses.
        consumer.setNamesrvAddr(mqAd);
        return consumer;
    }


}
