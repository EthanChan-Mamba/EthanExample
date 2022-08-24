package com.chen.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName ObjectStructure.java
 * @Description TODO
 * @createTime 2022-05-16 13:31
 */
public class ObjectStructure {

    private List<Person> persons = new LinkedList<Person>();

    // 增加到list
    public void attach(Person person) {
        persons.add(person);
    }

    // 移除
    public void detach(Person person) {
        persons.remove(person);
    }

    public void display(Action action) {
        for (Person person : persons) {
            person.accept(action);
        }
    }
}
