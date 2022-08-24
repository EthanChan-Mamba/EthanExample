package com.ethanChan.factory.absfactory.pizzastore.order;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName PizzaStore.java
 * @Description TODO
 * @createTime 2022-04-24 09:16
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}
