package com.ethanChan.iterator;

import java.util.Iterator;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName College.java
 * @Description TODO
 * @createTime 2022-05-22 11:39
 */
public interface College {

    public String getName();

    // 增加系
    public void addDepartment(String name, String desc);

    // 返回一个迭代器
    public Iterator createIterator();

}
