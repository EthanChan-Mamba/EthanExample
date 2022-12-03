package com.ethan.springEventExample.springEvent.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName PlaceOrderEventMessage.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:50
 */
@Data
public class PlaceOrderEventMessage implements Serializable {
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
