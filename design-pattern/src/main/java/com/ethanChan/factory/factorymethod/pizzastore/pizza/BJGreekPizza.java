package com.ethanChan.factory.factorymethod.pizzastore.pizza;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName GreekPizza.java
 * @Description TODO
 * @createTime 2022-04-23 21:27
 */
public class BJGreekPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京希腊披萨");
        System.out.println("希腊披萨准备");
    }
}
