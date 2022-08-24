package com.ethanChan.proxy.cglib;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-15 11:33
 */
public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();

        TeacherDao proxyInstance = (TeacherDao) new ProxyFactory(teacherDao).getProxyInstance();

        proxyInstance.teach();
    }
}
