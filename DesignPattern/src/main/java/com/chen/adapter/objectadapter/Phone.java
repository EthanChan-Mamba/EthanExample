package com.chen.adapter.objectadapter;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Phone.java
 * @Description TODO
 * @createTime 2022-05-03 23:36
 */
public class Phone {

    public void charging(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == 5) {
            System.out.println("电压5V，可以充电");
        } else if (iVoltage5V.output5V() > 5) {
            System.out.println("电压大于5V，不可以充电");
        }
    }
}
