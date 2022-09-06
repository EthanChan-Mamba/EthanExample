package com.ethanChan.flyweight;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2022-05-08 17:22
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }
}
