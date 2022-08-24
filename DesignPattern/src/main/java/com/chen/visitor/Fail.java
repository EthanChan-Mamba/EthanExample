package com.chen.visitor;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Success.java
 * @Description TODO
 * @createTime 2022-05-16 13:26
 */
public class Fail extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男人：失败");
    }

    @Override
    public void getWomanResult(Woman man) {
        System.out.println("女人：失败");
    }
}
