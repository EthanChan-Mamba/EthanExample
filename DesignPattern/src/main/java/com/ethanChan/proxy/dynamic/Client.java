package com.ethanChan.proxy.dynamic;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-14 23:30
 */
public class Client {
    public static void main(String[] args) {
        ITeacherDao teacherDao = new TeacherDao();

        // 给目标对象，创建代理对象，可以转ITeacherDao
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(teacherDao).getProxyInstance();

        System.out.println(proxyInstance.getClass());

        proxyInstance.teach();
    }
}
