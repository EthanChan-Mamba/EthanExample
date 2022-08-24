package com.ethanChan.decorator;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Coffee.java
 * @Description TODO
 * @createTime 2022-05-04 23:50
 */
public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
