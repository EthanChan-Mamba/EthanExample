package com.ethanChan.singleton.type1;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SingletonTest01.java
 * @Description TODO
 * @createTime 2022-04-23 16:20
 */
public class SingletonTest01 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }
}

/** 饿汉式 （静态常量）
 * 1. 类装载的时候完成实例化，避免线程同步问题
 * 2. 没有达到lazy loading的效果，如果没有使用这个实例，导致内存浪费
 * 3. 导致类装载的原因很多，不确定其他方法导致，初始化instance没有达到lazy loading效果
 *
 * 可用，可能导致内存浪费
 */
class Singleton{

    // 1. 构造器私有化，外部能new
    private Singleton() {

    }

    // 2. 本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    // 3. 对外提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }
}
