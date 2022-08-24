package com.ethanChan.facade;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName DVDPlayer.java
 * @Description TODO
 * @createTime 2022-05-07 13:24
 */
public class DVDPlayer {

    // 使用单例模式，饿汉式
    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("on");
    }

    public void off() {
        System.out.println("off");
    }

    public void play() {
        System.out.println("playing");
    }

    public void pause() {
        System.out.println("pause");
    }
}
