package com.chen.singleton.type5;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SingletonTest01.java
 * @Description TODO
 * @createTime 2022-04-23 16:20
 */
public class SingletonTest05 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
    }
}

/** 双重检测
 *
 * 1. 双重检查在多线程开发中常用，进行两次检查，保证线程安全
 * 2. 实例化代码只执行一次，后续访问，直接返回对象
 * 3.线程安全，延迟加载，效率较高
 *
 * 实际开发推荐
 */
class Singleton{
    private static volatile Singleton instance;

    private Singleton() {

    }

    // 提供一个静态的公有方法，加入双重检查代码，解决线程安全问题，同时解决懒加载问题
    // 同时保证效率
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
