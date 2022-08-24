package com.chen.bridge;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName XiaoMi.java
 * @Description TODO
 * @createTime 2022-05-04 23:04
 */
public class Vivo implements Brand {
    public void open() {
        System.out.println("Vivo手机开机");
    }

    public void close() {
        System.out.println("Vivo手机关机");
    }

    public void call() {
        System.out.println("Vivo手机打电话");
    }
}
