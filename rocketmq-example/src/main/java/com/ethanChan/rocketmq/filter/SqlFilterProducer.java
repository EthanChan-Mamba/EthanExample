package com.ethanChan.rocketmq.filter;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SqlFilterProducer.java
 * @Description sql过滤 putUserProperty来设置消息的属性
 * @createTime 2022-08-22 17:17
 */
public class SqlFilterProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("SqlFilterProducer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();

        String[] tags = {"TagA", "TagB", "TagC"};
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("SqlFilterTest"
                    , tags[i % tags.length]
                    , ("Hello world" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 设置SQL过滤的属性
            msg.putUserProperty("a", String.valueOf(i));
            SendResult send = producer.send(msg);
            System.out.printf("%s%n", send);
        }
        producer.shutdown();

    }
}
