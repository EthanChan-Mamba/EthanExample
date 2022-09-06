package com.ethanChan.factory.factorymethod.pizzastore.order;


import com.ethanChan.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName OrderPizza.java
 * @Description 工厂方法模式
 * @createTime 2022-04-23 21:27
 */
public abstract class OrderPizza {

    // 构造器
    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            // 工厂子类自己实现
            pizza = createPizza(orderType);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    // 定义抽象方法，createPizza，让工厂子类自己实现
    abstract Pizza createPizza(String orderType);

    // 写一个获取客户披萨的种类
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("pizza 种类：");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
