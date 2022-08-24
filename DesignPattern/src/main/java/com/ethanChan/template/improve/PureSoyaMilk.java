package com.ethanChan.template.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName PureSoyaMilk.java
 * @Description TODO
 * @createTime 2022-05-15 11:56
 */
public class PureSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
        // 空实现
    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
