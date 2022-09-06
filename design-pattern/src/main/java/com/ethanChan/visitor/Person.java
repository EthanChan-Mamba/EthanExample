package com.ethanChan.visitor;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Person.java
 * @Description TODO
 * @createTime 2022-05-16 13:25
 */
public abstract class Person {

    // 提供方法给访问者
    public abstract void accept(Action action);
}
