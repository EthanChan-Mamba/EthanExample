package com.ethanChan.visitor;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-16 13:33
 */
public class Client {

    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        Success success = new Success();
        objectStructure.display(success);
    }
}
