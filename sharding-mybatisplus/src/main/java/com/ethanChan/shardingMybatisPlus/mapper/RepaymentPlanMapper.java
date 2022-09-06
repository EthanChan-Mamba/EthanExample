package com.ethanChan.shardingMybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethanChan.shardingMybatisPlus.entity.CommunicationInfo;
import com.ethanChan.shardingMybatisPlus.entity.RepaymentPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName OrderMapper.java
 * @Description TODO
 * @createTime 2022-08-29 19:36
 */
@Mapper
public interface RepaymentPlanMapper extends BaseMapper<RepaymentPlan> {

}
