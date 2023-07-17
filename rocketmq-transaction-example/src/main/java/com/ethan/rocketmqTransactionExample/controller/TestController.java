package com.ethan.rocketmqTransactionExample.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.ethan.rocketmqTransactionExample.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-07-17 10:20
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/test")
    public R<String> test() {
        return businessService.saveA();
        // return null;
    }
}
