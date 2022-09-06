package com.ethanChan.strategy;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Duck.java
 * @Description TODO
 * @createTime 2022-05-25 13:27
 */
public abstract class Duck {
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
        System.out.println("鸭飞");
    }
}
