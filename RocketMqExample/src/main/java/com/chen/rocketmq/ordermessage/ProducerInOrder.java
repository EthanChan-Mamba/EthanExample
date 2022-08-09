package com.chen.rocketmq.ordermessage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName ProducerInOrder.java
 * @Description TODO
 * @createTime 2022-08-08 23:46
 */
public class ProducerInOrder {
    private List<Order> buildOrder() {
        List<Order> orderList = new ArrayList<Order>();
        Order order = new Order();
        order.setOrderId(001);
        order.setDesc("创建");
        orderList.add(order);
        return orderList;
    }

    private static class Order {
        private long orderId;
        private String desc;

        public long getOrderId() {
            return orderId;
        }

        public void setOrderId(long orderId) {
            this.orderId = orderId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
