package com.ethan.springEventExample.springEvent.listener;

import com.ethan.springEventExample.springEvent.entity.PlaceOrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderLogListener.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:52
 */
@Slf4j
@Service
public class OrderLogEventListener {

    @EventListener
    // 异步
    @Async("asyncExecutor")
    public void orderLog(PlaceOrderEvent event) {
        log.info("[afterPlaceOrder] log.");
    }
}
