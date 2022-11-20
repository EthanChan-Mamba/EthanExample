package com.ethanChan.countOnline.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyServletContextListener.java
 * @Description 存放用户IP
 * @Author EthanChan
 * @Version 1.0.0
 * @Date 2022-11-20 23:06
 */
@WebListener()
public class MyServletContextListener implements ServletContextListener {
    private ServletContext sc;

    @Override
    //Application被初始化的时候创建
    public void contextInitialized(ServletContextEvent sce) {
        //创建一个链表来存储IP
        List<String> ips = new ArrayList<>();
        sc = sce.getServletContext();
        //将创建好的链表对象，放到Application域中
        sc.setAttribute("ips",ips);
    }
}
