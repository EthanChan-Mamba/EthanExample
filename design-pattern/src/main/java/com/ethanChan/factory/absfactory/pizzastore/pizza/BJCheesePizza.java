package com.ethanChan.factory.absfactory.pizzastore.pizza;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName CheesePizza.java
 * @Description TODO
 * @createTime 2022-04-23 21:26
 */
public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪披萨");
        System.out.println("北京奶酪披萨准备");
    }
}
