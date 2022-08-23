package com.chen.rocketmq.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName TransactionListenerImpl.java
 * @Description TODO
 * @createTime 2022-08-23 11:27
 */
public class TransactionListenerImpl implements TransactionListener {
    /**
     * 执行本地事务
     * @param msg
     * @param arg
     * @return
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        // 执行本地事务 update A
        System.out.println("update A ... where transactionId: " + msg.getTransactionId());
        // 情况1: 本地事务成功
        // return LocalTransactionState.COMMIT_MESSAGE;
        // 情况2: 本地事务失败
        // return LocalTransactionState.ROLLBACK_MESSAGE;
        // 情况3: 业务复杂, 还处于中间过程或者依赖其他操作的返回结果, 就是unknow
        System.out.println("业务较长");
        return LocalTransactionState.UNKNOW;
    }

    /**
     * 事务回查 默认60s, 一分钟一次
     * @param msg
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        // 打印回查时间
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("checkLocalTransaction: " + df.format(new Date()));
        // 情况1: 业务回查成功成功
        // return LocalTransactionState.COMMIT_MESSAGE;
        // 情况2: 业务回查回滚
        // System.out.println("业务回查: 执行本地事务失败, 删除消息");
        // return LocalTransactionState.ROLLBACK_MESSAGE;
        // 情况3: 业务回查还是unknow
        System.out.println("业务较长");
        return LocalTransactionState.UNKNOW;
    }
}
