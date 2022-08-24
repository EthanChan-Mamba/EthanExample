package com.ethanChan.factory.simplefactory.pizzastore.order;

import com.ethanChan.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.ethanChan.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.ethanChan.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.ethanChan.factory.simplefactory.pizzastore.pizza.Pizza;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SimpleFactory.java
 * @Description 简单工厂类
 * @createTime 2022-04-23 21:46
 */
public class SimpleFactory {

    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }
        return pizza;
    }

    // 简单工厂模式，也叫静态工厂模式
    public static Pizza createPizza2(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }
        return pizza;
    }
}
