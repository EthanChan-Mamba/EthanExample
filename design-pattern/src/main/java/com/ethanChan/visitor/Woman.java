package com.ethanChan.visitor;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Woman.java
 * @Description 第一次分派：action，第二次分派：自己
 * @createTime 2022-05-16 13:25
 */
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
