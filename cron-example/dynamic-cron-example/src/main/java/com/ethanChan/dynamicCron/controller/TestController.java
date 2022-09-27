package com.ethanChan.dynamicCron.controller;

import com.ethanChan.dynamicCron.task.ScheduleTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description
 * @createTime 2022-09-27 10:05
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    private final ScheduleTask scheduleTask;

    @Autowired
    public TestController(ScheduleTask scheduleTask) {
        this.scheduleTask = scheduleTask;
    }

    /**
     * 调用接口动态修改该定时任务的执行时间
     * @param cron cron格式字符串
     * @return
     */
    @GetMapping("/updateCron")
    public String updateCron(String cron) {
        log.info("new cron :{}", cron);
        scheduleTask.setCron(cron);
        return "ok";
    }

    /**
     * 设置循环间隔时间，单位为毫秒
     * @param timer 循环间隔时间，单位为毫秒
     * @return
     */
    @GetMapping("/updateTimer")
    public String updateTimer(Long timer) {
        log.info("new timer :{}", timer);
        scheduleTask.setTimer(timer);
        return "ok";
    }
}
