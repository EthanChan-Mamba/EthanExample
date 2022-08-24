package com.chen.memento.game;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-22 20:38
 */
public class Client {
    public static void main(String[] args) {
        GameRole gameRole = new GameRole();
        gameRole.setDef(1);
        gameRole.setVit(1);

        System.out.println("大战前状态");
        gameRole.display();

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());

        System.out.println("大战");
        gameRole.setVit(10);
        gameRole.setDef(10);

        gameRole.display();

        System.out.println("大战后");
        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
        System.out.println("大战后状态");
        gameRole.display();
    }
}
