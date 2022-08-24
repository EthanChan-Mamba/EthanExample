package com.chen.memento.theory;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName theory.java
 * @Description TODO
 * @createTime 2022-05-22 20:19
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // 保存状态
    public Memento saveStateMemento() {
        return new Memento(state);
    }

    // 恢复状态
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
