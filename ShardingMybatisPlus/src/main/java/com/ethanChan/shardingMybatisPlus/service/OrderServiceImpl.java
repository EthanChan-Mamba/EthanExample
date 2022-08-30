package com.ethanChan.shardingMybatisPlus.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethanChan.shardingMybatisPlus.entity.Order;
import com.ethanChan.shardingMybatisPlus.mapper.OrderMapper;
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
// public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IService<Order> {

    @DS("gits_sharding")
    public List<Order> listOrder() {
        return list(new LambdaQueryWrapper<Order>().eq(Order::getOrderId, 0));
    }
    public List<Order> listOrder2() {
        return list(new LambdaQueryWrapper<Order>().eq(Order::getOrderId, 1));
    }

}
