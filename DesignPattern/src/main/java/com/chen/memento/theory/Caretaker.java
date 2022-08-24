package com.chen.memento.theory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Caretaker.java
 * @Description TODO
 * @createTime 2022-05-22 20:24
 */
public class Caretaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
