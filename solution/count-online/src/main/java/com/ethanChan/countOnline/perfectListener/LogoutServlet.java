package com.ethanChan.countOnline.perfectListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName LogoutServlet.java
 * @Description 页面点击关闭后，激活的退出方法 (与listener相比没有变动)
 * @Author EthanChan
 * @Version 1.0.0
 * @Date 2022-11-20 23:10
 */
@WebServlet(name = "LogoutServlet",urlPatterns = "/logoutServlet")
public class LogoutServlet extends HttpServlet {

    private HttpSession session;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从域中获取一个session，设置为false 如果域中存在一个session，则直接获取，如果不存在，则返回一个空的session
        session = request.getSession(false);
        if (session != null){
            //使session失效
            session.invalidate();
            //失效后，需要进行的操作，List链表中需要减去，用到了Session域监听器
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
