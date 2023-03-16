package com.ethan.springRetryExample.controller;

import com.ethan.springRetryExample.service.TestRetryService;
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
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestRetryService testRetryService;

    @GetMapping("/test")
    public int updateTimer(int code) throws Exception {
        return testRetryService.test(code);
    }
}
