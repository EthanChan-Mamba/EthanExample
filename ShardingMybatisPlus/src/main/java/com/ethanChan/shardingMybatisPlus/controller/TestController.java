package com.ethanChan.shardingMybatisPlus.controller;

import com.ethanChan.shardingMybatisPlus.entity.CommunicationInfo;
import com.ethanChan.shardingMybatisPlus.entity.Order;
import com.ethanChan.shardingMybatisPlus.service.CommunicationInfoServiceImpl;
import com.ethanChan.shardingMybatisPlus.service.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    CommunicationInfoServiceImpl communicationInfoService;

    @RequestMapping("/test")
    public List<Order> test() {
        return orderService.listOrder();
    }

    @RequestMapping("/test2")
    public List<Order> test2() {
        return orderService.listOrder2();
    }

    @RequestMapping("/test3")
    public void test3() {
        communicationInfoService.init();
    }
    @RequestMapping("/test4")
    public boolean test4() {
        return communicationInfoService.saveSlave(new CommunicationInfo().setInfoId(1));
    }
    @RequestMapping("/test5")
    public List<CommunicationInfo> test5() {
        return communicationInfoService.listSlave();
    }

}
