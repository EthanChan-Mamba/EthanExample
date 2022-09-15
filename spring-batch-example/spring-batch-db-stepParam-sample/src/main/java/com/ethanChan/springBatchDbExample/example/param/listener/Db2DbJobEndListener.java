package com.ethanChan.springBatchDbExample.example.param.listener;

import com.ethanChan.springBatchDbExample.common.LogConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

/**
 * 结束监听器
 * @author mason
 * @since 2019/6/1
 **/
@Slf4j
public class Db2DbJobEndListener extends JobExecutionListenerSupport {

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.debug(LogConstants.LOG_TAG + " batch job complete!");
        }
    }
}
