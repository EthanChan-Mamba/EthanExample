package com.ethanChan.prototype.deepclone;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-03 00:23
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype deepPrototype = new DeepPrototype();
        deepPrototype.name = "song";
        deepPrototype.deepCloneableTarget = new DeepCloneableTarget("daniu", "daniu类");

        // 方法1
        DeepCloneableTarget clone = (DeepCloneableTarget) deepPrototype.clone();
        System.out.println(deepPrototype.deepCloneableTarget.hashCode());
        System.out.println(clone.hashCode());
        // 方法2
        DeepCloneableTarget clone1 = (DeepCloneableTarget) deepPrototype.deepClone();
        System.out.println(deepPrototype.deepCloneableTarget.hashCode());
        System.out.println(clone1.hashCode());
    }
}
