package com.chen.iterator;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Department.java
 * @Description TODO
 * @createTime 2022-05-22 11:30
 */
public class Department {
    private String name;
    private String desc;

    public Department(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
