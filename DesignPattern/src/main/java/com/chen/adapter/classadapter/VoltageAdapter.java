package com.chen.adapter.classadapter;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName VoltageAdapter.java
 * @Description 适配器类
 * @createTime 2022-05-03 23:34
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {

    public int output5V() {
        // 获取到220V电压
        int srcV = output220V();
        // 转成5V
        int dstV = srcV / 44;
        return dstV;
    }
}
