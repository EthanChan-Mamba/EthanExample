package com.chen.builder.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName HouseBuilder.java
 * @Description TODO
 * @createTime 2022-05-03 12:57
 */
public abstract class HouseBuilder {

    protected House house = new House();

    // 将建造流程写好，抽象
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    // 将造好的房子返回
    public House buildHouse() {
        return house;
    }
}
