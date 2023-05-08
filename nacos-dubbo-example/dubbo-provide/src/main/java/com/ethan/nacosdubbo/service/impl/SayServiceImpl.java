package com.ethan.nacosdubbo.service.impl;

import com.ethan.nacosdubbo.service.SayService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @ClassName SayServiceImpl.java
 * @Description @DubboService是新版Dubbo的注解，如果是旧版比如2.7.3，使用的是org.apache.dubbo.config.annotation.Service这个注解
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-08 10:27
 */
@DubboService
public class SayServiceImpl implements SayService {
    @Override
    public String sayHelloByName(String name) {
        return name+",hello!";
    }
}
