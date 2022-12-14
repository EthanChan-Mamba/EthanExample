package com.ethanChan.springBatchDbExample.mapper.oringin;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethanChan.springBatchDbExample.entity.origin.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName OrderMapper.java
 * @Description TODO
 * @createTime 2022-09-08 15:35
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
