package com.ethanChan.factory.simplefactory.pizzastore.pizza;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName GreekPizza.java
 * @Description TODO
 * @createTime 2022-04-23 21:27
 */
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("希腊披萨准备");
    }
}
