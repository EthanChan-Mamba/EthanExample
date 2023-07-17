package com.ethan.rocketmqTransactionExample.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.api.R;
import com.ethan.rocketmqTransactionExample.entity.Student;
import com.ethan.rocketmqTransactionExample.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName BusinessService.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-07-17 11:30
 */
@Service
@Slf4j
public class BusinessService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TransactionMQProducer transactionMQProducer;


    public R<String> saveA() {
        try {
            Student a = new Student(1, "a");
            studentMapper.insert(a);
            String key = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            log.info(String.format("发送MQ消息:,key=%s", key));
            String bodyJson = JSON.toJSONString(a);
            Message message = new Message("risk_top", "TagA", bodyJson.getBytes(StandardCharsets.UTF_8));
            // 设置代表消息的业务关键属性，请尽可能全局唯一，以方便您在无法正常收到消息情况下，可通过 MQ 控制台查询消息并补发
            message.setKeys(key);

            TransactionSendResult sendResult = this.transactionMQProducer.sendMessageInTransaction(message
                    , new SendCallback() {
                        @Override
                        public void onSuccess(final SendResult sendResult) {
                            // 消息发送成功。
                            log.info("发送MQ消息成功：{}", bodyJson);
                        }

                        @Override
                        public void onException(Throwable e) {
                            // 发送失败。
                            log.error("发送MQ消息出现异常：", e);
                        }

                    });
            if (sendResult.getSendStatus() == SendStatus.SEND_OK) {
                return R.ok(key);
            }
            return R.failed("事务失败");
            // return rocketMqProducer.sendRiskService(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
            // , JSON.toJSONString(a));
        } catch (Exception e) {
            e.printStackTrace();
            return R.failed("事务失败");
        }

    }

    public ConsumeConcurrentlyStatus saveB(String messageBody) {

        // return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        Student student = JSON.parseObject(messageBody, Student.class);
        student.setName("update" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        int update = studentMapper.updateById(student);
        if (update == 1) {
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        } else {
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
    }

}
