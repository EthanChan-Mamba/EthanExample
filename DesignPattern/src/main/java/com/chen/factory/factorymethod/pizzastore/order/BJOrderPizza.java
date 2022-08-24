package com.chen.factory.factorymethod.pizzastore.order;

import com.chen.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.chen.factory.factorymethod.pizzastore.pizza.BJGreekPizza;
import com.chen.factory.factorymethod.pizzastore.pizza.Pizza;


/**
 * @author chen
 * @version 1.0.0
 * @ClassName OrderPizza.java
 * @Description TODO
 * @createTime 2022-04-23 21:27
 */
public class BJOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("greek")) {
            pizza = new BJGreekPizza();
        }
        return pizza;
    }
}
