package com.ethan.springEventExample.originObserver.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName PlaceOrderMessage.java
 * @Description 被观察者
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:23
 */
@Data
public class PlaceOrderMessage implements Serializable {
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 下单用户ID
     */
    private String userId;
    //……
}
