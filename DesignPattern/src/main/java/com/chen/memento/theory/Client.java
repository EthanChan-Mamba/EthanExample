package com.chen.memento.theory;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-22 20:25
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("1");

        caretaker.add(originator.saveStateMemento());

        originator.getStateFromMemento(caretaker.get(0));
    }
}
