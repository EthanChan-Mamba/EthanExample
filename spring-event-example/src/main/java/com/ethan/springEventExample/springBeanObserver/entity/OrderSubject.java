package com.ethan.springEventExample.springBeanObserver.entity;

import com.ethan.springEventExample.springBeanObserver.observer.OrderObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName OrderSubject.java
 * @Description 被观察者抽象类
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:32
 */
public abstract class OrderSubject {
    /**
     * 利用Spring的特性直接注入观察者
     */
    @Autowired
    protected List<OrderObserver> orderObserverList;

    //定义一个线程池,这里参数随便写的
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 12, 6, TimeUnit.SECONDS, new ArrayBlockingQueue<>(30));

    //通知所有观察者
    public void notifyObservers(PlaceOrderMessage placeOrderMessage) {
        for (OrderObserver orderObserver : orderObserverList) {
            //利用多线程异步执行
            threadPoolExecutor.execute(() -> {
                orderObserver.afterPlaceOrder(placeOrderMessage);
            });
        }
    }
}
