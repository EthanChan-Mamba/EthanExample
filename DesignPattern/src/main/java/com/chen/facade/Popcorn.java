package com.chen.facade;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Popcorn.java
 * @Description 爆米花
 * @createTime 2022-05-07 13:24
 */
public class Popcorn {

    // 使用单例模式，饿汉式
    private static Popcorn instance = new Popcorn();

    public static Popcorn getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("Popcorn on");
    }

    public void off() {
        System.out.println("Popcorn off");
    }

    public void pop() {
        System.out.println("Popcorn pop");
    }

}
