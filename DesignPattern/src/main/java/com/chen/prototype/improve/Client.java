package com.chen.prototype.improve;


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
        sheep.fri = new Sheep("dol", 2, "黑色");

        Sheep clone = (Sheep) sheep.clone();
        System.out.println(clone.fri.hashCode());
        Sheep clone1 = (Sheep) sheep.clone();
        System.out.println(clone1.fri.hashCode());
    }
}
