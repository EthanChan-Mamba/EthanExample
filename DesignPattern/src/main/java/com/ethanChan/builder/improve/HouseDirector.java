package com.ethanChan.builder.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName HouseDirector.java
 * @Description TODO
 * @createTime 2022-05-03 13:03
 */
public class HouseDirector {

    HouseBuilder houseBuilder = null;

    // 构造器
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // setter
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 将建房子流程交给指挥者
    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
