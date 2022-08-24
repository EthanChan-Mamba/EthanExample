package com.ethanChan.builder;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName CommonHouse.java
 * @Description TODO
 * @createTime 2022-05-03 12:00
 */
public class CommonHouse extends AbstractHouse {
    @Override
    public void buildBasic() {
        System.out.println("common build");
    }

    @Override
    public void buildWalls() {
        System.out.println("common build walls");
    }

    @Override
    public void roofed() {
        System.out.println("common build roofed");
    }
}
