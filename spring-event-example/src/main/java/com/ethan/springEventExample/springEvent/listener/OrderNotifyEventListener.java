package com.ethan.springEventExample.springEvent.listener;

import com.ethan.springEventExample.springEvent.entity.PlaceOrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderNotifyEventListener.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:56
 */
@Slf4j
@Service
public class OrderNotifyEventListener{

    @EventListener
    public void notify(PlaceOrderEvent event) {
        log.info("[afterPlaceOrder] notify.");
    }
}
