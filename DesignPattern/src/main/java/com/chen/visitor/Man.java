package com.chen.visitor;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Man.java
 * @Description TODO
 * @createTime 2022-05-16 13:25
 */
public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
