package com.ethanChan.facade;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Stereo.java
 * @Description 灯光
 * @createTime 2022-05-07 13:24
 */
public class TheaterLight {

    // 使用单例模式，饿汉式
    private static TheaterLight instance = new TheaterLight();

    public static TheaterLight getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("TheaterLight on");
    }

    public void off() {
        System.out.println("TheaterLight off");
    }

    public void dim() {
        System.out.println("TheaterLight dim");
    }
    public void bright() {
        System.out.println("TheaterLight bright");
    }

}
