package com.ethanChan.springBatchDbExample.example.param.step;

import com.ethanChan.springBatchDbExample.common.SyncConstants;
import com.ethanChan.springBatchDbExample.entity.origin.Order;
import com.ethanChan.springBatchDbExample.service.origin.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName OrderReader.java
 * @Description TODO
 * @createTime 2022-09-08 16:11
 */
@Slf4j
public class OrderItemReader implements ItemReader<Order> {
    protected List<Order> items;

    protected Map<String, Object> params;
    @Autowired
    private OrderServiceImpl originUserService;

    private StepExecution stepExecution;

    public StepExecution getStepExecution() {
        return stepExecution;
    }

    public void setStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public Order read() {
        if (Objects.isNull(items)) {
            items = originUserService.list();
            ExecutionContext executionContext = stepExecution.getJobExecution().getExecutionContext();
            //readNum参数
            executionContext.put(SyncConstants.PASS_PARAM_READ_NUM, items.size());
            //datetime参数
            executionContext.put(SyncConstants.PASS_PARAM_DATETIME,params.get(SyncConstants.PASS_PARAM_DATETIME));
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
}
