package com.ethan.nacosdubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName DubboProviderApplication.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-08 11:11
 */
@SpringBootApplication
@EnableDubbo
public class DubboProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
