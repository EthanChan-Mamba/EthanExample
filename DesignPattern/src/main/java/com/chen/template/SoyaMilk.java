package com.chen.template;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SoyaMilk.java
 * @Description 抽象类，表示豆浆
 * @createTime 2022-05-15 11:46
 */
public abstract class SoyaMilk {

    // 模板方法，final，不让子类覆盖
    final void make() {
        select();
        addCondiments();
        soak();
        beat();
    }

    // 选材料
    void select() {
        System.out.println("第一步，选新鲜黄豆");
    }

    // 添加不同配料，抽象方法，子类实现
    abstract void addCondiments();

    // 浸泡
    void soak() {
        System.out.println("第三步，黄豆和配料浸泡");
    }

    // 打碎
    void beat() {
        System.out.println("第四步，黄豆和配料放到豆浆机打碎");
    }

}
