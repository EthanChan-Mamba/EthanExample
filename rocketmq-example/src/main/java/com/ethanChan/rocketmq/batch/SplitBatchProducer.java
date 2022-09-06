package com.ethanChan.rocketmq.batch;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName BatchProducer.java
 * @Description TODO
 * @createTime 2022-08-13 18:44
 */
public class SplitBatchProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("BatchProducer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();

        String topic = "BatchTest";
        List<Message> messages = new ArrayList<>(100 * 1000);
        // 10万元素的数组
        for (int i = 0; i < 100 * 1000; i++) {
            messages.add(new Message(topic, "TagA", "OrderID" + i, ("Hello world " + i).getBytes()));
        }
        // 把大的消息切成若干小的消息（1M左右）
        ListSplitter splitter = new ListSplitter(messages);
        while (splitter.hasNext()) {
            List<Message> next = splitter.next();
            producer.send(next);
            Thread.sleep(100);
        }

        producer.shutdown();
    }
}
