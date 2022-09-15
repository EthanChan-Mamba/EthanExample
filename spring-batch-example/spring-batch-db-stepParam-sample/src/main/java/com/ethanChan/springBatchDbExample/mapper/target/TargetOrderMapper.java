package com.ethanChan.springBatchDbExample.mapper.target;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethanChan.springBatchDbExample.entity.origin.Order;
import com.ethanChan.springBatchDbExample.entity.target.TargetOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName OrderMapper.java
 * @Description TODO
 * @createTime 2022-09-08 15:35
 */
@Mapper
public interface TargetOrderMapper extends BaseMapper<TargetOrder> {
}
