package com.ethan.rocketmqTransactionExample.config;

import com.ethan.rocketmqTransactionExample.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class ConsumeListenerImpl implements MessageListenerConcurrently {

    @Autowired
    private BusinessService businessService;


    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        for (Message message : msgs) {
            String messageBody = new String(message.getBody());
            String tag = message.getTags();
            log.info(LocalDateTime.now() + " Receive message, Topic is:" + message.getTopic() + ", Tag is:" + tag);
            log.info("mq信息tag：{}，内容：{}", tag, messageBody);

            try {
                return businessService.saveB(messageBody);
            } catch (Exception e) {
                log.error("message {}异常信息：", message, e);
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
