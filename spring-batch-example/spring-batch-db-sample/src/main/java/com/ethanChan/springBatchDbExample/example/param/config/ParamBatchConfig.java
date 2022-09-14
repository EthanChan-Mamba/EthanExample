package com.ethanChan.springBatchDbExample.example.param.config;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.ethanChan.springBatchDbExample.common.SyncConstants;
import com.ethanChan.springBatchDbExample.controller.ExcelOperateServiceImpl;
import com.ethanChan.springBatchDbExample.entity.origin.Order;
import com.ethanChan.springBatchDbExample.example.param.CommonItemReader;
import com.ethanChan.springBatchDbExample.example.param.CommonMybatisItemReader;
import com.ethanChan.springBatchDbExample.example.param.listener.Db2DbJobEndListener;
import com.ethanChan.springBatchDbExample.example.param.step.OrderItemReader;
import com.ethanChan.springBatchDbExample.example.param.step.OrderItemWriter;
import com.ethanChan.springBatchDbExample.example.param.step.ParamItemProcessor;
import com.ethanChan.springBatchDbExample.util.SpringContextUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.weaver.ast.Or;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName ParamBatchConfig.java
 * @Description TODO
 * @createTime 2022-09-08 16:08
 */
@Configuration
@EnableBatchProcessing
public class ParamBatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job paramJob(Step paramStep, JobExecutionListener paramListener) {
        String funcName = "OrderBatch";
        return jobBuilderFactory.get(funcName)
                .listener(paramListener)
                .flow(paramStep)
                .end().build();
    }


    @Bean
    public Step paramStep(ItemReader paramItemReader, ItemProcessor paramProcessor
    // public Step paramStep(ItemProcessor paramProcessor
            , ItemWriter paramWriter) {
        String funcName = Thread.currentThread().getStackTrace()[1].getMethodName();
        return stepBuilderFactory.get(funcName)
                // chunk就是数据块，你需要定义多大的数据量是一个chunk
                .<Order, Order>chunk(1)
                .reader(paramItemReader)
                .processor(paramProcessor)
                .writer(paramWriter)
                .build();
    }

    @Autowired
    ExcelOperateServiceImpl excelOperateService;

    @Bean
    @StepScope
    public ItemReader paramItemReader(@Value("#{stepExecution}") StepExecution stepExecution,
                                      @Value("#{jobParameters['time']}") Long timeParam) {
        // OrderItemReader userItemReader = new OrderItemReader();
        CommonItemReader<Order> orderCommonItemReader = new CommonItemReader<>();
        orderCommonItemReader.setTarget(new Order());
        //设置参数，当前示例可不设置参数
        Map<String, Object> params = new HashMap<>();
        Date datetime = new Date(timeParam);
        params.put(SyncConstants.PASS_PARAM_DATETIME, datetime);
        orderCommonItemReader.setParams(params);
        orderCommonItemReader.setStepExecution(stepExecution);

        return orderCommonItemReader;
    }
    @Bean
    public ItemWriter paramWriter() {
        return new OrderItemWriter();
    }

    @Bean
    public ItemProcessor paramProcessor() {
        return new ParamItemProcessor();
    }

    @Bean
    public JobExecutionListener paramListener() {
        return new Db2DbJobEndListener();
    }
}
