package com.ethanChan.factory.factorymethod.pizzastore.order;

import com.ethanChan.factory.factorymethod.pizzastore.pizza.*;


/**
 * @author chen
 * @version 1.0.0
 * @ClassName OrderPizza.java
 * @Description TODO
 * @createTime 2022-04-23 21:27
 */
public class LDOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        } else if (orderType.equals("greek")) {
            pizza = new LDGreekPizza();
        }
        return pizza;
    }
}
