package com.ethanChan.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName University.java
 * @Description 管理College
 * @createTime 2022-05-05 13:25
 */
public class College extends OrganizationComponent {

    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

    public College(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
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
        for (OrganizationComponent o : organizationComponents) {
            o.print();
        }
    }
}
