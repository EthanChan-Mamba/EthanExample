package com.ethan.springEventExample.springBeanObserver.observer;

import com.ethan.springEventExample.springBeanObserver.entity.PlaceOrderMessage;

/**
 * @ClassName OrderObserver.java
 * @Description 观察者接口
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:20
 */
public interface OrderObserver {

    void afterPlaceOrder(PlaceOrderMessage placeOrderMessage);

}
