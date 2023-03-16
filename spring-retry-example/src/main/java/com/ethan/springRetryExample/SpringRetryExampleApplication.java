package com.ethan.springRetryExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @ClassName SpringRetryExampleApplication.java
 * @Description SpringRetryExample
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-03-16 15:19
 */
@EnableRetry
@SpringBootApplication
public class SpringRetryExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRetryExampleApplication.class, args);
    }

}
