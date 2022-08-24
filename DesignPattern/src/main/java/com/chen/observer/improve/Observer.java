package com.chen.observer.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Observer.java
 * @Description 观察者接口
 * @createTime 2022-05-22 16:21
 */
public interface Observer {
    public void update(float temperature, float pressure, float humidity);
}
