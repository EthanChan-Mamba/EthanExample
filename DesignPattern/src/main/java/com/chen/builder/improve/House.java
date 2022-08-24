package com.chen.builder.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName House.java
 * @Description 产品-product
 * @createTime 2022-05-03 12:55
 */
public class House {
    private String basic;
    private String wall;
    private String roofed;

    public House() {

    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public House(String basic, String wall, String roofed) {
        this.basic = basic;
        this.wall = wall;
        this.roofed = roofed;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
