package com.ethanChan.singleton.type6;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SingletonTest01.java
 * @Description TODO
 * @createTime 2022-04-23 16:20
 */
public class SingletonTest06 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
    }
}

/** 静态内部类
 * 1. 采用类加载机制保证初始化实例只有一个线程
 * 2. 静态内部类在类装载的时候不会立即实例化，而是在需要实例化时调用公共方法，才会装载内部类，完成实例化
 * 3. 类的静态属性只有在第一次装载的时候初始化，所以jvm帮助我们保证线程安全
 * 4. 避免线程不安全，利用静态内部类实现延迟加载，效率高
 *
 * 实际开发推荐
 */
class Singleton{
    private static volatile Singleton instance;

    private Singleton() {

    }

    // 写一个静态内部类，有静态属性
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 提供一个静态的公有方法，直接返回
    public static synchronized Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
