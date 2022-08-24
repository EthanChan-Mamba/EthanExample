package com.ethanChan.proxy.dynamic;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName TeacherDao.java
 * @Description TODO
 * @createTime 2022-05-14 23:18
 */
public class TeacherDao implements ITeacherDao {
    public void teach() {
        System.out.println("老师正在授课");
    }
}
