package com.chen.builder;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName AbstractHouse.java
 * @Description TODO
 * @createTime 2022-05-03 11:57
 */
public abstract class AbstractHouse {

    // 打地基
    public abstract void buildBasic();
    // 砌墙
    public abstract void buildWalls();
    // 封顶
    public abstract void roofed();

    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }

}
