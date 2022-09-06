package com.ethanChan.redisInterfaceLimit.controller;

import com.ethanChan.redisInterfaceLimit.annotion.RateLimiter;
import com.ethanChan.redisInterfaceLimit.domain.LimitType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName HelloController.java
 * @Description TODO
 * @createTime 2022-06-09 13:56
 */
@RestController
public class HelloController {
    /**
     * 每一个 IP 地址，在 5 秒内只能访问 3 次。
     * @return
     */
    @GetMapping("/hello")
    @RateLimiter(time = 5,count = 3,limitType = LimitType.IP)
    public String hello() {
        return "hello>>>"+new Date();
    }
}
