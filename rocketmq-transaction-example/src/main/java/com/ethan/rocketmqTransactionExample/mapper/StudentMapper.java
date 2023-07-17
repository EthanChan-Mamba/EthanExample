package com.ethan.rocketmqTransactionExample.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.rocketmqTransactionExample.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName MemberMapper.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-29 14:15
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
