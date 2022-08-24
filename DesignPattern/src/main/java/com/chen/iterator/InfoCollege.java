package com.chen.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName ComputerCollege.java
 * @Description TODO
 * @createTime 2022-05-22 11:40
 */
public class InfoCollege implements College {
    List<Department> departmentList;

    public String getName() {
        return "信息学院";
    }

    public InfoCollege() {
        departmentList = new ArrayList<Department>();
        addDepartment("信息安全", "信息安全");
        addDepartment("网络安全", "网络安全");
    }

    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departmentList.add(department);
    }

    public Iterator createIterator() {
        return new InfoCollegeIterator(departmentList);
    }
}
