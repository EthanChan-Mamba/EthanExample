package com.ethan.springEventExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassName SpringEventExampleApplication.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:36
 */
@SpringBootApplication
@EnableAsync
public class SpringEventExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringEventExampleApplication.class, args);
    }

}
