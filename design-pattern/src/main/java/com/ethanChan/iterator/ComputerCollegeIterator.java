package com.ethanChan.iterator;

import java.util.Iterator;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName ComputerCollegeIterator.java
 * @Description TODO
 * @createTime 2022-05-22 11:31
 */
public class ComputerCollegeIterator implements Iterator {

    // 需要知道Department以什么形式存放
    Department[] departments;
    int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    public boolean hasNext() {
        if (position >= departments.length || departments[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    public Object next() {
        Department department = departments[position];
        position++;
        return department;
    }

    // 空实现
    public void remove() {

    }
}
