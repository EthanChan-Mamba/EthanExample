package com.ethan.rocketmqTransactionExample.config;

import com.alibaba.fastjson.JSON;
import com.ethan.rocketmqTransactionExample.entity.Student;
import com.ethan.rocketmqTransactionExample.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName TransactionListenerImpl.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-07-17 15:23
 */
@Component
@Slf4j
public class TransactionListenerImpl implements TransactionListener {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        String transactionId = msg.getTransactionId();
        log.info("开始执行本地事务，事务编号：" + transactionId);
        try {
            String studentPojo = new String(msg.getBody(), StandardCharsets.UTF_8);
            Student student = JSON.parseObject(studentPojo, Student.class);
            student.setId(2);
            int insert = studentMapper.insert(student);
            if (insert != 1) {
                return LocalTransactionState.ROLLBACK_MESSAGE;
            }
            log.info("结束执行本地事务，事务编号：" + transactionId);
            return LocalTransactionState.COMMIT_MESSAGE;
        } catch (Exception e) {
            log.info("update order error: ", e);
            log.info("结束执行本地事务，事务编号：" + transactionId);
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
    }

    /**
     * 在断网或者是生产者应用重启的特殊情况下
     * ，若 Broker 未收到发送者提交的二次确认结果，或 Broker 收到的二次确认结果为 Unknown 未知状态
     * ，经过固定时间后，服务端将对消息生产者即生产者集群中任一生产者实例发起消息回查。
     * @param msg Check message
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        // String transactionId = msg.getTransactionId();
        String studentPojo = new String(msg.getBody(), StandardCharsets.UTF_8);
        LocalTransactionState localTransactionState = LocalTransactionState.UNKNOW;
        try {
            log.info("检测本地事务，事务编号：" + 2);
            Student student1 = studentMapper.selectById(2);
            if (student1 != null) {
                localTransactionState = LocalTransactionState.COMMIT_MESSAGE;
            } else {
                localTransactionState = LocalTransactionState.UNKNOW;
            }
        } catch (Exception e) {
            log.error("checkLocalTransaction error:", e);
            localTransactionState = LocalTransactionState.UNKNOW;
        }
        log.info("检测本地事务，事务编号：" + 2 + " 事务状态：" + localTransactionState);
        return localTransactionState;
    }

}
