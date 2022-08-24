package com.chen.adapter.objectadapter;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName VoltageAdapter.java
 * @Description 适配器类
 * @createTime 2022-05-03 23:34
 */
public class VoltageAdapter implements IVoltage5V {

    // 关联关系-聚合
    private Voltage220V voltage220V;

    // 通过构造器，传入Voltage220V实例
    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    public int output5V() {
        int dst = 0;
        if (voltage220V != null) {
            // 获取到220V电压
            int srcV = voltage220V.output220V();
            System.out.println("使用对象适配器");
            // 转成5V
            dst = srcV / 44;
            System.out.println("适配完成");
        }
        return dst;
    }
}
