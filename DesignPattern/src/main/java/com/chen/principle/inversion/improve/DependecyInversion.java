package com.chen.principle.inversion.improve;

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

interface IReceive {
    public String getInfo();
}

class Email implements IReceive{
    public String getInfo() {
        return "Email";
    }
}

//增加微信
class WeiXin implements IReceive {
    public String getInfo() {
        return "微信信息: hello,ok";
    }
}

// 方式2
class Person {
    public void receive(IReceive receive) {
        System.out.println(receive.getInfo());
    }
}
