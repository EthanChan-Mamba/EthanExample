package com.ethanChan.decorator;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName CoffeeBar.java
 * @Description TODO
 * @createTime 2022-05-05 00:01
 */
public class CoffeeBar {
    public static void main(String[] args) {
        Drink order = new LongBlack();

        order = new Milk(order);
        order = new Chocolate(order);
        float price = order.cost();
        String des = order.getDes();
    }
}
