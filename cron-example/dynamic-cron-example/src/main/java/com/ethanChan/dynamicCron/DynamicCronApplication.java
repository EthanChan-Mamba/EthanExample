package com.ethanChan.dynamicCron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName DynamicCronApplication.java
 * @Description TODO
 * @createTime 2022-09-27 10:02
 */
@EnableScheduling
@SpringBootApplication
public class DynamicCronApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicCronApplication.class, args);
        System.out.println("(*^▽^*)启动成功!!!(〃'▽'〃)");
    }
}
