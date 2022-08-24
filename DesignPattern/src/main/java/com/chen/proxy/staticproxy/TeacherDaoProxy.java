package com.chen.proxy.staticproxy;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName TeacherDaoProxy.java
 * @Description 代理对象，静态代理
 * @createTime 2022-05-09 13:30
 */
public class TeacherDaoProxy implements ITeacherDao {

    // 目标对象，通过接口聚合
    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    public void teach() {
        System.out.println("代理开始");
        target.teach();
        System.out.println("提交");
    }
}
