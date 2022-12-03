package com.ethan.springEventExample.springBeanObserver.observer.impl;

import com.ethan.springEventExample.springBeanObserver.entity.PlaceOrderMessage;
import com.ethan.springEventExample.springBeanObserver.observer.OrderObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderNotifyObserver.java
 * @Description 业务通知观察者
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:30
 */
@Slf4j
@Service
public class OrderNotifyObserver implements OrderObserver {

    @Override
    public void afterPlaceOrder(PlaceOrderMessage placeOrderMessage) {
        log.info("[afterPlaceOrder] notify.");
    }
}
