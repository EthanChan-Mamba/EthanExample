package com.ethanChan.singleton.type7;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SingletonTest01.java
 * @Description TODO
 * @createTime 2022-04-23 16:20
 */
public class SingletonTest06 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
    }
}

/** 使用枚举
 * 1. 使用jdk1.5添加的枚举实现，避免多线程同步问题，还能防止反序列化重新创建新对象
 * 2. 是Effective Java作者提倡
 *
 * 实际开发推荐
 */
enum Singleton{
    INSTANCE;
    public void sayOk() {
        System.out.println("ok");
    }
}
