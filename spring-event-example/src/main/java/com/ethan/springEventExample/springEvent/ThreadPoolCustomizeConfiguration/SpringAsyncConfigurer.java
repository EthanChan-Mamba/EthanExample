package com.ethan.springEventExample.springEvent.ThreadPoolCustomizeConfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @ClassName SpringAsyncConfigurer.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:59
 */
@Configuration
@Slf4j
public class SpringAsyncConfigurer extends AsyncConfigurerSupport {

    @Bean
    public ThreadPoolTaskExecutor asyncExecutor() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        //随便写的一些配置
        threadPool.setCorePoolSize(10);
        threadPool.setMaxPoolSize(30);
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        threadPool.setAwaitTerminationSeconds(60 * 15);
        return threadPool;
    }

    @Override
    public Executor getAsyncExecutor() {
        return asyncExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> log.error(String.format("[async] task{} error:", method), ex);
    }
}
