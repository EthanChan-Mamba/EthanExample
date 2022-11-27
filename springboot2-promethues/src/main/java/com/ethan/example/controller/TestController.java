package com.ethan.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description TODO
 * @createTime 2022-08-29 19:42
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/test")
    public boolean test() {
        return true;
    }
}
