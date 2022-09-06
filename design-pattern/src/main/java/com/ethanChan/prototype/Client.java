package com.ethanChan.prototype;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-02 23:49
 */
public class Client {
    public static void main(String[] args) {
        // 传统方法
        Sheep sheep = new Sheep("tom", 1, "白色");

        Sheep sheep1 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
    }
}
