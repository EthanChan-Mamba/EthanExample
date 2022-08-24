package com.ethanChan.memento.theory;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName theory.java
 * @Description TODO
 * @createTime 2022-05-22 20:19
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
