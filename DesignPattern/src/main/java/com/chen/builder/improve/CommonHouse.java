package com.chen.builder.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName CommonHouse.java
 * @Description TODO
 * @createTime 2022-05-03 13:01
 */
public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("common build basic");
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
