package com.chen.strategy.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Duck.java
 * @Description TODO
 * @createTime 2022-05-25 13:27
 */
public abstract class Duck {

    // 属性，策略接口
    FlyBehavior flyBehavior;

    public Duck() {
    }

    // 显示鸭子信息
    public abstract void display();

    public void quack() {
        System.out.println("鸭叫");
    }

    public void swim() {
        System.out.println("鸭游");
    }

    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }
}
