package com.ethan.rocketmqTransactionExample.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class InitApplicationListener implements ApplicationRunner {

    @Autowired
    private RocketMqConsumer rocketMqConsumer;

    @Override
    public void run(ApplicationArguments args) throws MQClientException {
        rocketMqConsumer.startRiskServiceTCP();
    }
}
