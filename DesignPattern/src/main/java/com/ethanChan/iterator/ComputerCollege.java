package com.ethanChan.iterator;

import java.util.Iterator;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName ComputerCollege.java
 * @Description TODO
 * @createTime 2022-05-22 11:40
 */
public class ComputerCollege implements College {
    Department[] departments;
    // 保存当前数组的对象个数
    int numOfDepartment = 0;

    public String getName() {
        return "计算机学院";
    }

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("java", "java");
        addDepartment("php", "php");
        addDepartment("data", "data");
    }

    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[numOfDepartment] = department;
        numOfDepartment++;
    }

    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
