package com.chen.factory.absfactory.pizzastore.order;

import com.chen.factory.absfactory.pizzastore.pizza.BJCheesePizza;
import com.chen.factory.absfactory.pizzastore.pizza.BJGreekPizza;
import com.chen.factory.absfactory.pizzastore.pizza.Pizza;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName BJFactory.java
 * @Description 工厂子类
 * @createTime 2022-04-24 09:07
 */
public class BJFactory implements AbsFactory {
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("greek")) {
            pizza = new BJGreekPizza();
        }
        return pizza;
    }
}
