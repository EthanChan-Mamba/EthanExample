package com.ethanChan.countOnline.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

/**
 * @ClassName MySessionListener.java
 * @Description 因为要统计在线人数，所以要设置退出按钮，点击退出按钮之后
 *          ，因为要从List域中移除，所以使用Session域监听器来判断session回话的关闭
 * @Author EthanChan
 * @Version 1.0.0
 * @Date 2022-11-20 23:09
 */
@WebListener()
public class MySessionListener implements HttpSessionListener {

    private ServletContext sc;
    private List<String> ips;
    private HttpSession session;
    private Object clientIp;

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sc = se.getSession().getServletContext();
        ips = (List<String>) sc.getAttribute("ips");
        session = se.getSession();
        clientIp = session.getAttribute("clientIp");
        //删除ip，如何获取IP，但是不可以从session获取到IP
        //因为Session获取不到Request
        //一个Session包含多个Request
        //一个Request只对应一个Session 所以获取不到，这时只能先从Request域中获取到的ips，放置到Session域
        //然后从Session 域中读取
        ips.remove(clientIp);
        // session一失效就马上将此IP从链表中移除是错误的
        //应该看此IP是否有另外的回话存在，如果有的话不能删除
    }
}
