package com.ethanChan.springBatchDbExample.entity.origin;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Order.java
 * @Description TODO
 * @createTime 2022-09-08 15:32
 */
@Data
@TableName("order1")
public class Order {
    @TableId
    Integer id;
    String name;
}
