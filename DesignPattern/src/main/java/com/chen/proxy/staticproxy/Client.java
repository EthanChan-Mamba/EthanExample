package com.chen.proxy.staticproxy;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-09 13:32
 */
public class Client {
    public static void main(String[] args) {
        // 创建目标对象（被代理对象）
        TeacherDao teacherDao = new TeacherDao();

        // 创建代理对象，同时将被代理对象传递给代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        // 通过代理对象，调用被代理对象方法
        // 执行的是代理对象方法，代理对象再去调用被代理对象方法
        teacherDaoProxy.teach();

    }
}
