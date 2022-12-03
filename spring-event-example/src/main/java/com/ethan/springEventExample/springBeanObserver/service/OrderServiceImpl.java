package com.ethan.springEventExample.springBeanObserver.service;

import com.ethan.springEventExample.entity.PlaceOrderReqVO;
import com.ethan.springEventExample.entity.PlaceOrderResVO;
import com.ethan.springEventExample.springBeanObserver.entity.OrderSubject;
import com.ethan.springEventExample.springBeanObserver.entity.PlaceOrderMessage;
import com.ethan.springEventExample.springBeanObserver.observer.OrderObserver;
import com.ethan.springEventExample.springBeanObserver.observer.impl.OrderLogObserver;
import com.ethan.springEventExample.springBeanObserver.observer.impl.OrderMetricsObserver;
import com.ethan.springEventExample.springBeanObserver.observer.impl.OrderNotifyObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderServiceImpl.java
 * @Description 订单实现类-被观察者实现类
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:33
 */
@Service
@Slf4j
public class OrderServiceImpl extends OrderSubject {
    /**
     * 实现类里也要注入一下
     */
    @Autowired
    private List<OrderObserver> orderObserverList;

    /**
     * 下单
     */
    public PlaceOrderResVO placeOrder(PlaceOrderReqVO reqVO) {
        PlaceOrderResVO resVO = new PlaceOrderResVO();
        //通知观察者
        this.notifyObservers(new PlaceOrderMessage());
        log.info("[placeOrder] end.");
        return resVO;
    }
}
