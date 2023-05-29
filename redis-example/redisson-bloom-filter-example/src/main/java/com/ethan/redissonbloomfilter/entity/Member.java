package com.ethan.redissonbloomfilter.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Member.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-09 17:33
 */
@Data
public class Member {

    private Integer id;

    private String username;

    private Date birthday;

    private Integer gender;

}
