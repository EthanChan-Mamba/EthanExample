package com.ethanChan.flyweight;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName ConcreteWebsite.java
 * @Description TODO
 * @createTime 2022-05-08 17:13
 */
public class ConcreteWebsite extends Website {

    // 网站类型
    private String type = "";

    public ConcreteWebsite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站类型：" + type + "使用:" + user.getName());
    }
}
