package com.ethanChan.countOnline.perfectListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MyServletContextListener.java
 * @Description 存放用户IP
 * @Author EthanChan
 * @Version 1.0.0
 * @Date 2022-11-20 23:18
 */
@WebListener()
public class MyServletContextListener implements ServletContextListener {
    private ServletContext sc;
    @Override
    //Application被初始化的时候创建
    public void contextInitialized(ServletContextEvent sce) {
        //创建一个Map，key为IP，value为该IP上所发出的会话的对象
        Map<String, List<HttpSession>> map = new HashMap<>();
        sc = sce.getServletContext();
        //将map放到全局域中
        sc.setAttribute("map",map);
    }
}
