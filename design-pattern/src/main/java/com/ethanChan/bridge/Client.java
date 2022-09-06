package com.ethanChan.bridge;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-04 23:17
 */
public class Client {
    public static void main(String[] args) {
        Phone foldedPhone = new FoldedPhone(new XiaoMi());
        foldedPhone.open();
        foldedPhone.call();
        foldedPhone.close();
    }
}
