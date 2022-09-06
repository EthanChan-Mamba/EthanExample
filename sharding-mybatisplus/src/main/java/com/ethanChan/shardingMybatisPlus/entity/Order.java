package com.ethanChan.shardingMybatisPlus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Order.java
 * @Description TODO
 * @createTime 2022-08-29 19:33
 */
@Data
@TableName("t_order")
public class Order {
    @TableId
    Integer orderId;
    String orderName;
    Integer orderStatus;
    Integer userId;
}
