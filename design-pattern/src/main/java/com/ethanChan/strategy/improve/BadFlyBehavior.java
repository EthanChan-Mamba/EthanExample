package com.ethanChan.strategy.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName GoodFlyBehavior.java
 * @Description TODO
 * @createTime 2022-05-26 13:14
 */
public class BadFlyBehavior implements FlyBehavior {
    public void fly() {
        System.out.println("bad fly");
    }
}
