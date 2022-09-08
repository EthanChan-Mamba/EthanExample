package com.ethanExample.springBatchExample.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName BatchConfig.java
 * @Description @EnableBatchProcessing创建的概述
 *   JobRepository (bean名称 "jobRepository")
 *   JobLauncher (bean名称 "jobLauncher")
 *   JobRegistry (bean名称 "jobRegistry")
 *   JobExplorer (bean名称 "jobExplorer")
 *   PlatformTransactionManager (bean名称 "transactionManager")
 *   JobBuilderFactory (bean名称"jobBuilders")，它可以方便地防止您必须将作业存储库注入到每个Job(作业)中
 *   StepBuilderFactory (bean名称 "stepBuilders")，以方便您避免将作业存储库和事务管理器注入到每个Step(步骤)中
 * @createTime 2022-09-08 11:16
 */

@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {

    @Override
    public void setDataSource(DataSource dataSource) {
        // initialize will use a Map based JobRepository (instead of database)
    }
}
