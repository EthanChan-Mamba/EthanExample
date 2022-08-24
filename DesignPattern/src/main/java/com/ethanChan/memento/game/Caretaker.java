package com.ethanChan.memento.game;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Caretaker.java
 * @Description 守护者对象，保存游戏角色状态
 * @createTime 2022-05-22 20:32
 */
public class Caretaker {
    // 只保存一次状态
    private Memento memento;
    // 对角色保存多次状态
    // private List<Memento> mementos;
    // 对多个角色，保存多次状态
    // private HashMap<String, ArrayList<Memento>> rolesHashMap;


    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
