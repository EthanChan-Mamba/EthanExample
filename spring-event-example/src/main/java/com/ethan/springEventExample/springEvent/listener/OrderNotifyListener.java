package com.ethan.springEventExample.springEvent.listener;

import com.ethan.springEventExample.springEvent.entity.PlaceOrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderNotifyListener.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:53
 */
@Slf4j
@Service
public class OrderNotifyListener implements ApplicationListener<PlaceOrderEvent> {

    @Override
    public void onApplicationEvent(PlaceOrderEvent event) {
        log.info("[afterPlaceOrder] notify.");
    }
}
