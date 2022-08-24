package com.ethanChan.rocketmq.requestReply;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.RequestCallback;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName RequestReplyProducer.java
 * @Description PRC方式中，生产者也可以使用异步方式发起
 * @createTime 2022-08-23 14:12
 */
public class RequestReplyProducerAsync {
    public static void main(String[] args) throws MQClientException {
        String producerGroup = "RPC";
        String topic = "RequestTopic";
        // 超时时间
        long ttl = 3000;

        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr("127.0.0..1:9876");
        producer.start();

        try {
            Message message = new Message(topic, "", "Hello World".getBytes(RemotingHelper.DEFAULT_CHARSET));
            long begin = System.currentTimeMillis();
            producer.request(message, new RequestCallback() {
                @Override
                public void onSuccess(Message message) {
                    long cost = System.currentTimeMillis() - begin;
                    System.out.printf("request to <%s> cost: %dms replymessage: %s %n", topic, cost, message);

                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.printf("request to <%s> fail.", topic);
                }
            }, ttl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        producer.shutdown();

    }
}
