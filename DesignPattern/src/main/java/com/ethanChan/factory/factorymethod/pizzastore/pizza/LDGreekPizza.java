package com.ethanChan.factory.factorymethod.pizzastore.pizza;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName GreekPizza.java
 * @Description TODO
 * @createTime 2022-04-23 21:27
 */
public class LDGreekPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦希腊披萨");
        System.out.println("伦敦披萨准备");
    }
}
