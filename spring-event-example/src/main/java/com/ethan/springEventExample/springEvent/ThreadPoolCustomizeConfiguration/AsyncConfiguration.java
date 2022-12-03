package com.ethan.springEventExample.springEvent.ThreadPoolCustomizeConfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName AsyncConfiguration.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:58
 */
@Configuration
@Slf4j
public class AsyncConfiguration implements AsyncConfigurer {

    @Bean("fighter3AsyncExecutor")
    public ThreadPoolTaskExecutor executor() {
        //Spring封装的一个线程池
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //随便写的一些配置
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(30);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("fighter3AsyncExecutor-");
        executor.initialize();
        return executor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return executor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> log.error(String.format("[async] task{} error:", method), ex);
    }
}
