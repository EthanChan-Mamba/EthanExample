package com.ethanChan.strategy.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Duck.java
 * @Description TODO
 * @createTime 2022-05-25 13:27
 */
public class PekingDuck extends Duck {

    public PekingDuck() {
        flyBehavior = new BadFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("这是北京鸭");
    }

}
