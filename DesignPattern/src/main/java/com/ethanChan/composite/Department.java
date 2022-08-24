package com.ethanChan.composite;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName University.java
 * @Description 管理College
 * @createTime 2022-05-05 13:25
 */
public class Department extends OrganizationComponent {

    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    // 输出University包含的学院
    @Override
    protected void print() {
        System.out.println(getName());
    }
}
