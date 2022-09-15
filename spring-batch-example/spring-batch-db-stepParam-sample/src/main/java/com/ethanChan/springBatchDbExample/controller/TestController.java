package com.ethanChan.springBatchDbExample.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ethanChan.springBatchDbExample.common.SyncConstants;
import com.ethanChan.springBatchDbExample.dto.ResponseResult;
import com.ethanChan.springBatchDbExample.entity.origin.Order;
import com.ethanChan.springBatchDbExample.entity.target.TargetOrder;
import com.ethanChan.springBatchDbExample.service.OperateServiceImpl;
import com.ethanChan.springBatchDbExample.service.batch.JobLauncherService;
import com.ethanChan.springBatchDbExample.service.origin.OrderServiceImpl;
import com.ethanChan.springBatchDbExample.service.target.TargetOrderServiceImpl;
import com.ethanChan.springBatchDbExample.util.JobUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description TODO
 * @createTime 2022-08-29 19:42
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    TargetOrderServiceImpl targetOrderService;

    @Autowired
    private JobLauncherService jobLauncherService;

    @Autowired
    private Job paramJob;

    @Autowired
    OperateServiceImpl excelOperateService;

    @RequestMapping("/test")
    public List<Order> test() {
        return orderService.list();
    }
    @RequestMapping("/test1")
    public List<Order> test1() {
        return orderService.listSlave();
    }
    @RequestMapping("/test2")
    public boolean test2() {
        TargetOrder order = new TargetOrder();
        order.setName("iiiii");
        order.setId(12);
        TargetOrder order1 = new TargetOrder();
        order1.setId(13);
        order1.setName("jjjj");
        ArrayList<TargetOrder> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        return targetOrderService.insertSlave(orders);
    }
    @RequestMapping("/test3")
    public void test3() {
        List<Object> list = excelOperateService.commonMapperSelect(Order.class, new LambdaQueryWrapper<Order>().gt(Order::getId, "1"));
        System.out.println(list);
    }


    @GetMapping("/run_job1")
    public ResponseResult<String> runJob1() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = JobUtil.makeJobParameters();
        Map<String, Object> stringObjectMap = jobLauncherService.startJob(paramJob, jobParameters);
        Object resultStr = stringObjectMap.get(SyncConstants.STR_RETURN_RESULT);
        return ResponseResult.ok(resultStr);
    }
}
