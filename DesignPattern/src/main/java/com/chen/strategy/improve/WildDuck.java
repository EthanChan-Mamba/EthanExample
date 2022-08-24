package com.chen.strategy.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Duck.java
 * @Description TODO
 * @createTime 2022-05-25 13:27
 */
public class WildDuck extends Duck {

    // 构造器，传入FlyBehavior对象
    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("这是野鸭");
    }
}
