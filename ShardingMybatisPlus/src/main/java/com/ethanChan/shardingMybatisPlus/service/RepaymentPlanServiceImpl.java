package com.ethanChan.shardingMybatisPlus.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethanChan.shardingMybatisPlus.entity.CommunicationInfo;
import com.ethanChan.shardingMybatisPlus.entity.RepaymentPlan;
import com.ethanChan.shardingMybatisPlus.mapper.CommunicationInfoMapper;
import com.ethanChan.shardingMybatisPlus.mapper.RepaymentPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName OrderService.java
 * @Description TODO
 * @createTime 2022-08-29 19:35
 */
@Service
public class RepaymentPlanServiceImpl extends ServiceImpl<RepaymentPlanMapper, RepaymentPlan> implements IService<RepaymentPlan> {

    @DS("sharding_db")
    public List<RepaymentPlan> listSharding(String LoanTime) {

        LambdaQueryWrapper<RepaymentPlan> wrapper = new LambdaQueryWrapper<RepaymentPlan>()
                .eq(RepaymentPlan::getSharding, LoanTime);
        return getBaseMapper().selectList(wrapper);
    }
}
