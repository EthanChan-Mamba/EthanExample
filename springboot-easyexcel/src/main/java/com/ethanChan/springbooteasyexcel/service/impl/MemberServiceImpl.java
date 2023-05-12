package com.ethanChan.springbooteasyexcel.service.impl;

import com.ethanChan.springbooteasyexcel.entity.Member;
import com.ethanChan.springbooteasyexcel.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MemberServiceImpl.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-09 17:39
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public List<Member> getAllMember() {
        // 这里构造一些测试数据，具体业务场景可从数据库等其他地方获取
        List<Member> list = new ArrayList<>();
        Member member = new Member();
        member.setUsername("张三");
        member.setBirthday(getDate(1990, 10, 11));
        member.setGender(0);
        list.add(member);

        Member member1 = new Member();
        member1.setUsername("王红");
        member1.setBirthday(getDate(1999, 3, 29));
        member1.setGender(1);
        list.add(member1);

        Member member2 = new Member();
        member2.setUsername("李四");
        member2.setBirthday(getDate(2000, 2, 9));
        member2.setGender(0);
        list.add(member2);

        return list;
    }

    private Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}
