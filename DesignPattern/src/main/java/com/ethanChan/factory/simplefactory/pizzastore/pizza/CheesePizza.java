package com.ethanChan.factory.simplefactory.pizzastore.pizza;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName CheesePizza.java
 * @Description TODO
 * @createTime 2022-04-23 21:26
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("奶酪披萨准备");
    }
}
