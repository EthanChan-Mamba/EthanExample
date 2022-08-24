package com.chen.proxy.staticproxy;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName TeacherDao.java
 * @Description TODO
 * @createTime 2022-05-09 13:28
 */
public class TeacherDao implements ITeacherDao {
    public void teach() {
        System.out.println("老师在授课");
    }
}
