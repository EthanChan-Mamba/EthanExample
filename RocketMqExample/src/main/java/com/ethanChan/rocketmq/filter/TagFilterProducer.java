package com.ethanChan.rocketmq.filter;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName TagFilterProducer.java
 * @Description 根据发送三种tag的msg
 * @createTime 2022-08-22 17:17
 */
public class TagFilterProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("TagFilterProducer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();

        String[] tags = {"TagA", "TagB", "TagC"};
        for (int i = 0; i < 60; i++) {
            Message msg = new Message("TagFilterTest"
                    , tags[i % tags.length]
                    , "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult send = producer.send(msg);
            System.out.printf("%s%n", send);
        }
        producer.shutdown();

    }
}
