package com.ethan.nacosdubbo.controller;

import com.ethan.nacosdubbo.service.SayService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SayController.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-08 13:32
 */
@RestController
@RequestMapping("/demo/say")
public class SayController {

    @DubboReference
    private SayService sayService;

    @GetMapping("/sayHello")
    public ResponseEntity<String> sayHello(@RequestParam("name") String name) {
        return ResponseEntity.ok(sayService.sayHelloByName(name));
    }
}
