package com.ethanChan.springBatchDbExample.example.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ethanChan.springBatchDbExample.common.SyncConstants;
import com.ethanChan.springBatchDbExample.service.OperateServiceImpl;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName CommonFileItemReader.java
 * @Description 读取数据库公共reader
 * @createTime 2022-09-13 14:31
 */
public class CommonItemReader<T> implements ItemReader<T> {
    protected List<T> items;
    protected Map<String, Object> params;
    protected T target;
    private StepExecution stepExecution;
    @Autowired
    OperateServiceImpl excelOperateService;

    public StepExecution getStepExecution() {
        return stepExecution;
    }
    public void setStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }


    @Override
    public T read() {
        if (Objects.isNull(items)) {
            Map<String, Object> params = this.getParams();
            QueryWrapper queryWrapper = (QueryWrapper) params.get("QueryWrapper");
            items = (List<T>) excelOperateService.commonMapperSelect(target.getClass(), queryWrapper);
            ExecutionContext executionContext = stepExecution.getJobExecution().getExecutionContext();
            //readNum参数
            executionContext.put(SyncConstants.PASS_PARAM_READ_NUM, items.size());
            //datetime参数
            executionContext.put(SyncConstants.PASS_PARAM_DATETIME, this.params.get(SyncConstants.PASS_PARAM_DATETIME));
            if (items.size() > 0) {
                return items.remove(0);
            }
        } else {
            if (!items.isEmpty()) {
                return items.remove(0);
            }
        }
        return null;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public void setTarget(T target) {
        this.target = target;
    }
}
