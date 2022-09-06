package com.ethanChan.singleton.type4;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SingletonTest01.java
 * @Description TODO
 * @createTime 2022-04-23 16:20
 */
public class SingletonTest04 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
    }
}

/** 懒汉式（线程安全）
 *
 * 1. 解决线程安全
 * 2. 效率低，每次获取实例都妖执行getInstance进行同步。只执行一次实例化代码即可
 * 3. 同步代码块的方法并不能企到线程同步的作用，进入if语句未执行，另一个线程也会创建实例
 *
 * 实际开发不推荐
 */
class Singleton{
    private static Singleton instance;

    private Singleton() {

    }

    // 提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
