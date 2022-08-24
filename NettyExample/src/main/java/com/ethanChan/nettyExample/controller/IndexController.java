package com.ethanChan.nettyExample.controller;

import cn.hutool.core.util.RandomUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName IndexController.java
 * @Description TODO
 * @createTime 2022-08-19 09:55
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mav=new ModelAndView("socket");
        mav.addObject("uid", RandomUtil.randomNumbers(6));
        return mav;
    }

}
