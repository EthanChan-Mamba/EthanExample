package com.ethan.springEventExample.springEvent.entity;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName PlaceOrderEvent.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:49
 */
public class PlaceOrderEvent extends ApplicationEvent {

    public PlaceOrderEvent(PlaceOrderEventMessage source) {
        super(source);
    }

}
