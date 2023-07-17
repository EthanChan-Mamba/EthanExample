package com.ethan.rocketmqTransactionExample.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Student.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-07-17 10:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @TableId
    private int id;
    private String name;
}
