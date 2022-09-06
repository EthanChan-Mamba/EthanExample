package com.ethanChan.singleton.type3;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SingletonTest01.java
 * @Description TODO
 * @createTime 2022-04-23 16:20
 */
public class SingletonTest03 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
    }
}

/** 懒汉式（线程不安全）
 *
 * 1. 起到了lazy loading效果，只能在单线程下使用
 * 2. 在多线程下，进入if判断语句，还没有往下执行，另一个线程也通过这个判断语句，会产生多个实例
 *
 * 实际开发不要用
 */
class Singleton{
    private static Singleton instance;

    private Singleton() {

    }

    // 提供一个静态的公有方法，当使用到该方法时，才去创建instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
