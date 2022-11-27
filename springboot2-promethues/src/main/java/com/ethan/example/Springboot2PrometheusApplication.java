package com.ethan.example;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName Springboot2PrometheusApplication.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-11-27 11:23
 */
@SpringBootApplication
public class Springboot2PrometheusApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2PrometheusApplication.class, args);
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName){
        return registry -> registry.config().commonTags("application", applicationName);
    }
}
