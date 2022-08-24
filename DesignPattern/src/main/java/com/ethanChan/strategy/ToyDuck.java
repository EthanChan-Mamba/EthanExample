package com.ethanChan.strategy;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Duck.java
 * @Description TODO
 * @createTime 2022-05-25 13:27
 */
public class ToyDuck extends Duck {

    @Override
    public void display() {
        System.out.println("这是玩具鸭");
    }

    @Override
    public void quack() {
        System.out.println("鸭不会叫");
    }

    @Override
    public void swim() {
        System.out.println("鸭不会游");
    }

    @Override
    public void fly() {
        System.out.println("鸭不会飞");
    }
}
