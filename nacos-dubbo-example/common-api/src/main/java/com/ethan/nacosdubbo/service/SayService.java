package com.ethan.nacosdubbo.service;

/**
 * @ClassName SayService.java
 * @Description
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-08 10:23
 */
public interface SayService {
    /**
     * 根据名字say hello
     * @param name 名字
     * @return name + hello
     */
    String sayHelloByName(String name);
}
