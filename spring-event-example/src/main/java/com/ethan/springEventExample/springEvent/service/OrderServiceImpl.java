package com.ethan.springEventExample.springEvent.service;

import com.ethan.springEventExample.entity.PlaceOrderReqVO;
import com.ethan.springEventExample.entity.PlaceOrderResVO;
import com.ethan.springEventExample.springEvent.entity.PlaceOrderEvent;
import com.ethan.springEventExample.springEvent.entity.PlaceOrderEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderServiceImpl.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 22:02
 */
@Service
@Slf4j
public class OrderServiceImpl {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 下单
     */
    public PlaceOrderResVO placeOrder(PlaceOrderReqVO reqVO) {
        log.info("[placeOrder] start.");
        PlaceOrderResVO resVO = new PlaceOrderResVO();
        //消息
        PlaceOrderEventMessage eventMessage = new PlaceOrderEventMessage();
        //发布事件
        applicationEventPublisher.publishEvent(new PlaceOrderEvent(eventMessage));
        log.info("[placeOrder] end.");
        return resVO;
    }
}
