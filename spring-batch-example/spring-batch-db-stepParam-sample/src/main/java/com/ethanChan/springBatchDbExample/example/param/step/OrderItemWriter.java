package com.ethanChan.springBatchDbExample.example.param.step;

import com.ethanChan.springBatchDbExample.common.SyncConstants;
import com.ethanChan.springBatchDbExample.entity.target.TargetOrder;
import com.ethanChan.springBatchDbExample.service.target.TargetOrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * User写入类
 *
 * @author mason
 * @since 2019/5/31
 */
@Slf4j
public class OrderItemWriter implements ItemWriter<TargetOrder>, StepExecutionListener {
    @Autowired
    private TargetOrderServiceImpl targetUserService;

    private StepExecution stepExecution;

    @Override
    public void write(List<? extends TargetOrder> items) {
        ExecutionContext executionContext = stepExecution.getJobExecution().getExecutionContext();
        Object currentWriteNum = executionContext.get(SyncConstants.PASS_PARAM_WRITE_NUM);
        if (Objects.nonNull(currentWriteNum)) {
            log.info("currentWriteNum:{}", currentWriteNum);
            executionContext.put(SyncConstants.PASS_PARAM_WRITE_NUM, items.size()+(Integer)currentWriteNum);
        } else {
            executionContext.put(SyncConstants.PASS_PARAM_WRITE_NUM, items.size());
        }

        List<TargetOrder> targetOrderList = new ArrayList<>(items);
//        targetUserService.saveBatch(users);
        targetUserService.saveOrUpdateBatchSlava(targetOrderList);
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return stepExecution.getExitStatus();
    }
}
