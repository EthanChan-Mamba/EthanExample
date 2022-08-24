package com.chen.adapter.classadapter;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Voltage220V.java
 * @Description 被适配的类
 * @createTime 2022-05-03 23:30
 */
public class Voltage220V {
    /**
     * 输出220V电压
     * @return
     */
    public int output220V() {
        int src = 220;
        System.out.println("输出220v");
        return src;
    }
}
