package com.chen.factory.simplefactory.pizzastore.pizza;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName PepperPizza.java
 * @Description TODO
 * @createTime 2022-04-23 21:37
 */
public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("胡椒披萨准备");
    }
}
