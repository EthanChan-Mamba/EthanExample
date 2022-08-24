package com.ethanChan.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName OutPutImpl.java
 * @Description TODO
 * @createTime 2022-05-22 11:48
 */
public class OutPutImpl {

    List<College> collegeList;

    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    // 遍历所有学院，输出学院的系
    public void printCollege() {
        Iterator<College> iterator = collegeList.iterator();

        while (iterator.hasNext()) {
            College next = iterator.next();
            System.out.println(next.getName());
            // 得到相应的迭代器
            printDepartment(next.createIterator());
        }
    }

    // 输出学院 输出系
    public void printDepartment(Iterator iterator) {
        while (iterator.hasNext()) {
            Department next = (Department) iterator.next();
            System.out.println(next.getName());
        }
    }
}
