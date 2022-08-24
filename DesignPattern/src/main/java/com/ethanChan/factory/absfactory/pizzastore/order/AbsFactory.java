package com.ethanChan.factory.absfactory.pizzastore.order;

import com.ethanChan.factory.absfactory.pizzastore.pizza.Pizza;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName AbsFactory.java
 * @Description 一个抽象工厂模式的抽象层(接口)
 * @createTime 2022-04-24 09:05
 */
public interface AbsFactory {

    // 让子类实现
    public Pizza createPizza(String orderType);
}
