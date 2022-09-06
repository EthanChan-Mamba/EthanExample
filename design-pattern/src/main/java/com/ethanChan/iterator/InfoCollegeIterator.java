package com.ethanChan.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName ComputerCollegeIterator.java
 * @Description TODO
 * @createTime 2022-05-22 11:31
 */
public class InfoCollegeIterator implements Iterator {

    List<Department> departmentList;
    int index = -1;

    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public boolean hasNext() {
        if (index >= departmentList.size() - 1) {
            return false;
        } else {
            index++;
            return true;
        }
    }

    public Object next() {
        return departmentList.get(index);
    }

    // 空实现
    public void remove() {

    }
}
