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
public class OrderPizza {

    SimpleFactory simpleFactory;
    Pizza pizza = null;

    // 构造器
    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory) {
        String orderType = "";
        this.simpleFactory = simpleFactory;
        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);
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

    // 构造器
    // public OrderPizza() {
    //     Pizza pizza = null;
    //     String orderType;
    //     do {
    //         orderType = getType();
    //         if (orderType.equals("greek")) {
    //             pizza = new GreekPizza();
    //             pizza.setName("希腊披萨");
    //         } else if (orderType.equals("cheese")) {
    //             pizza = new CheesePizza();
    //             pizza.setName("奶酪披萨");
    //         } else if (orderType.equals("pepper")) {
    //             pizza = new PepperPizza();
    //             pizza.setName("胡椒披萨");
    //         } else {
    //             break;
    //         }
    //         pizza.prepare();
    //         pizza.bake();
    //         pizza.cut();
    //         pizza.box();
    //     } while (true);
    // }

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
