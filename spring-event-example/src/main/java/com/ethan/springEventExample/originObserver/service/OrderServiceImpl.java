package com.ethan.springEventExample.originObserver.service;

import com.ethan.springEventExample.entity.PlaceOrderReqVO;
import com.ethan.springEventExample.entity.PlaceOrderResVO;
import com.ethan.springEventExample.originObserver.entity.OrderSubject;
import com.ethan.springEventExample.originObserver.entity.PlaceOrderMessage;
import com.ethan.springEventExample.originObserver.observer.impl.OrderLogObserver;
import com.ethan.springEventExample.originObserver.observer.impl.OrderMetricsObserver;
import com.ethan.springEventExample.originObserver.observer.impl.OrderNotifyObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
     * 下单
     */
    public PlaceOrderResVO placeOrder(PlaceOrderReqVO reqVO) {
        PlaceOrderResVO resVO = new PlaceOrderResVO();
        //添加观察者
        this.addObserver(new OrderMetricsObserver());
        this.addObserver(new OrderLogObserver());
        this.addObserver(new OrderNotifyObserver());
        //通知观察者
        this.notifyObservers(new PlaceOrderMessage());
        log.info("[placeOrder] end.");
        return resVO;
    }
}
