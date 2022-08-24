package com.chen.visitor;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Action.java
 * @Description TODO
 * @createTime 2022-05-16 13:20
 */
public abstract class Action {

    // 得到男性测评
    public abstract void getManResult(Man man);
    // 得到女性测评
    public abstract void getWomanResult(Woman man);
}
