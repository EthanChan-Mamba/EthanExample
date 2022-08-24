package com.chen.factory.absfactory.pizzastore.order;

import com.chen.factory.absfactory.pizzastore.pizza.*;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName BJFactory.java
 * @Description 工厂子类
 * @createTime 2022-04-24 09:07
 */
public class LDFactory implements AbsFactory {
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        } else if (orderType.equals("greek")) {
            pizza = new LDGreekPizza();
        }
        return pizza;
    }
}
