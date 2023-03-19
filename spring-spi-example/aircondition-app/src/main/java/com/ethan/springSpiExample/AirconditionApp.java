package com.ethan.springSpiExample;

import java.util.ServiceLoader;

/**
 * @ClassName AirconditionApp.java
 * @Description 启动
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-03-19 22:51
 */
public class AirconditionApp {
    public static void main(String[] args) {
        new AirconditionApp().turnOn("VerticalType");
    }

    public void turnOn(String type){
        ServiceLoader<IAircondition> load = ServiceLoader
                .load(IAircondition.class);

        for (IAircondition iAircondition : load) {
            System.out.println("检测到:"+iAircondition.getClass().getSimpleName());
            if (type.equals(iAircondition.getType())){
                iAircondition.turnOnOff();
            }
        }
    }
}
