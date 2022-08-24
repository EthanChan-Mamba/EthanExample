package com.ethanChan.facade;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Screen.java
 * @Description 屏幕
 * @createTime 2022-05-07 13:24
 */
public class Screen {

    // 使用单例模式，饿汉式
    private static Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }

    public void up() {
        System.out.println("Screen up");
    }

    public void down() {
        System.out.println("Screen down");
    }

}
