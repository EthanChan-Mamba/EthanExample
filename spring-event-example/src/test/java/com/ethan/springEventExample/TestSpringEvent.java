package com.ethan.springEventExample;

import com.ethan.springEventExample.entity.PlaceOrderReqVO;
import com.ethan.springEventExample.originObserver.service.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @ClassName TestSpringEvent.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-03 21:38
 */
@SpringBootTest(classes = SpringEventExampleApplication.class)
@WebAppConfiguration
public class TestSpringEvent {
    @Autowired
    OrderServiceImpl orderService;

    @Test
    @DisplayName("下单")
    void placeOrder() {
        PlaceOrderReqVO placeOrderReqVO = new PlaceOrderReqVO();
        orderService.placeOrder(placeOrderReqVO);
    }
}
