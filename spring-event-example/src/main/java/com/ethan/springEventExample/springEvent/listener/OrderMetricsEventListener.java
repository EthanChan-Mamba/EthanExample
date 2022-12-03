package com.ethan.springEventExample.springEvent.listener;

import com.ethan.springEventExample.springEvent.entity.PlaceOrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderMetricsEventListener.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:55
 */
@Slf4j
@Service
public class OrderMetricsEventListener {

    @EventListener
    public void metrics(PlaceOrderEvent event) {
        log.info("[afterPlaceOrder] metrics");
    }
}
