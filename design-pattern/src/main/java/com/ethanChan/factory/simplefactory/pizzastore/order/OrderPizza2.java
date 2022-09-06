package com.ethanChan.factory.simplefactory.pizzastore.order;

import com.ethanChan.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName OrderPizza.java
 * @Description TODO
 * @createTime 2022-04-23 21:27
 */
public class OrderPizza2 {

    String orderType;
    Pizza pizza = null;

    // 构造器
    public OrderPizza2() {
        do {
            orderType = getType();
            pizza = SimpleFactory.createPizza2(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购披萨失败");
                break;
            }
        } while (true);
    }

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
