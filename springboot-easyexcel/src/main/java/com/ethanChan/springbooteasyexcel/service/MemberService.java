package com.ethanChan.springbooteasyexcel.service;

import com.ethanChan.springbooteasyexcel.entity.Member;

import java.util.List;

/**
 * @ClassName MemberService.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-09 17:38
 */
public interface MemberService {
    /**
     * 获取所有的成员信息
     * @return 成员信息列表
     */
    List<Member> getAllMember();
}
