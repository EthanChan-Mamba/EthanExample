package com.ethanChan.singleton.type2;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SingletonTest01.java
 * @Description TODO
 * @createTime 2022-04-23 16:20
 */
public class SingletonTest02 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }
}

/** 饿汉式 （静态方法）
 *
 * 可用，可能导致内存浪费
 */
class Singleton{

    // 1. 构造器私有化，外部能new
    private Singleton() {

    }

    // 2. 本类内部创建对象实例
    private static Singleton instance;

    static {
        // 在静态代码块，创建单例对象
        instance = new Singleton();
    }

    // 3. 对外提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }
}
