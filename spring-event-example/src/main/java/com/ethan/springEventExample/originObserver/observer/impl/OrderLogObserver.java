package com.ethan.springEventExample.originObserver.observer.impl;

import com.ethan.springEventExample.originObserver.entity.PlaceOrderMessage;
import com.ethan.springEventExample.originObserver.observer.OrderObserver;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName OrderLogObserver.java
 * @Description 日志记录观察者
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:30
 */
@Slf4j
public class OrderLogObserver implements OrderObserver {

    @Override
    public void afterPlaceOrder(PlaceOrderMessage placeOrderMessage) {
        log.info("[afterPlaceOrder] log.");
    }
}
