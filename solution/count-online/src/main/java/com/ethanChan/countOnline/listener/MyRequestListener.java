package com.ethanChan.countOnline.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName MyRequestListener.java
 * @Description 由于IP只能在Request域中获取，所以遍历判断在Request域中进行。
 * @Author EthanChan
 * @Version 1.0.0
 * @Date 2022-11-20 23:08
 */
@WebListener()
public class MyRequestListener implements ServletRequestListener {

    private HttpServletRequest sr;
    private String clientIp;
    private ServletContext sc;
    private List<String> ips;
    private HttpSession session;

    @Override
    //请求被初始化 Request
    public void requestInitialized(ServletRequestEvent sre) {
        //从请求域中获取IP
        sr = (HttpServletRequest) sre.getServletRequest();
        clientIp = sr.getRemoteAddr();
        session = sr.getSession();
        session.setAttribute("clientIp",clientIp);

        //测试
        // System.out.println("clientIp = "+ clientIp);
        //获取Application域中的List
        sc = sre.getServletContext();
        ips = (List<String>) sc.getAttribute("ips");
        //遍历ips
        for (String ip :
                ips) {
            if (clientIp.equals(ip)) {
                return;
            }
        }
        ips.add(clientIp);
        sc.setAttribute("ips",ips);
    }
}
