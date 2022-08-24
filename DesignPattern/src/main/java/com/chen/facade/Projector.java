package com.chen.facade;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Projector.java
 * @Description 投影仪
 * @createTime 2022-05-07 13:24
 */
public class Projector {

    // 使用单例模式，饿汉式
    private static Projector instance = new Projector();

    public static Projector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("Projector on");
    }

    public void off() {
        System.out.println("Projector off");
    }

    public void focus() {
        System.out.println("Projector focus");
    }

}
