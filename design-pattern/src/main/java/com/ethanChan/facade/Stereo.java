package com.ethanChan.facade;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Stereo.java
 * @Description 立体声
 * @createTime 2022-05-07 13:24
 */
public class Stereo {

    // 使用单例模式，饿汉式
    private static Stereo instance = new Stereo();

    public static Stereo getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("Stereo on");
    }

    public void off() {
        System.out.println("Stereo off");
    }

    public void up() {
        System.out.println("Stereo up");
    }

}
