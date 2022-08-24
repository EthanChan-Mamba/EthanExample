package com.chen.template.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-15 11:52
 */
public class Client {
    public static void main(String[] args) {
        SoyaMilk redBeanSoyaMile = new RedBeanSoyaMile();
        redBeanSoyaMile.make();

        PureSoyaMilk pureSoyaMilk = new PureSoyaMilk();
        pureSoyaMilk.make();
    }
}
