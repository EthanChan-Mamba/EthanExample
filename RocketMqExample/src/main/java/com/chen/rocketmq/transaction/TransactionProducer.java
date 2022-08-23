package com.chen.rocketmq.transaction;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.*;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName TransactionProducer.java
 * @Description TODO
 * @createTime 2022-08-23 11:25
 */
public class TransactionProducer {
    public static void main(String[] args) throws Exception {
        // 创建事务监听器
        TransactionListenerImpl transactionListener = new TransactionListenerImpl();
        TransactionMQProducer producer = new TransactionMQProducer("TransactionProducer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS
                , new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("client-transaction-msg-check-thread");
                return thread;
            }
        });
        // 设置生产者回查线程池
        producer.setExecutorService(executorService);
        // 生产者设置事务回查监听器
        producer.setTransactionListener(transactionListener);
        // 启动
        producer.start();

        // 半事务发送
        // 1. 开启事务
        System.out.println("开启@Transaction");
        try {
            Message message = new Message("TransactionTopic", null, ("A向B转100").getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.sendMessageInTransaction(message, null);
            // 半事务是否成功
            System.out.println(sendResult.getSendStatus());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 等待, 因为要输入密码等操作, 因为事务要回查
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000);
        }

        producer.shutdown();

    }
}
