package com.chen.factory.factorymethod.pizzastore.pizza;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName PepperPizza.java
 * @Description TODO
 * @createTime 2022-04-23 21:37
 */
public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦胡椒披萨");
        System.out.println("胡椒披萨准备");
    }
}
