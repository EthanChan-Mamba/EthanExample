package com.chen.principle.inversion;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName DependecyInversion.java
 * @Description TODO
 * @createTime 2022-04-17 15:17
 */
public class DependecyInversion {
    public static void main(String[] args) {

    }
}

class Email {
    public String getInfo() {
        return "Email";
    }
}

// 方式1
// 1. 简单
// 2. 如果获取的对象是微信，短信等， Person也要增加相应的方法
// 3.解决：引入抽象接口，表示接收者， Person和接口发生依赖
// 新增类实现接口即可
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
