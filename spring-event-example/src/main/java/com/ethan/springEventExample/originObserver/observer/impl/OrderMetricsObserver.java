package com.ethan.springEventExample.originObserver.observer.impl;

import com.ethan.springEventExample.originObserver.entity.PlaceOrderMessage;
import com.ethan.springEventExample.originObserver.observer.OrderObserver;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName OrderMetricsObserver.java
 * @Description 监控埋点观察者
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:24
 */
@Slf4j
public class OrderMetricsObserver implements OrderObserver {

    @Override
    public void afterPlaceOrder(PlaceOrderMessage placeOrderMessage) {
        log.info("[afterPlaceOrder] metrics");
    }
}
