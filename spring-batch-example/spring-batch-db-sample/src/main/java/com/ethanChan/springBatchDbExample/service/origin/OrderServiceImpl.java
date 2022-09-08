package com.ethanChan.springBatchDbExample.service.origin;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethanChan.springBatchDbExample.entity.origin.Order;
import com.ethanChan.springBatchDbExample.mapper.oringin.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName OrderServiceImpl.java
 * @Description TODO
 * @createTime 2022-09-08 15:35
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IService<Order> {

    @DS("slave")
    public List<Order> listSlave() {
        return list();
    }

    @DS("slave")
    public boolean insertSlave(List<Order> order) {
        return saveBatch(order);
    }
}
