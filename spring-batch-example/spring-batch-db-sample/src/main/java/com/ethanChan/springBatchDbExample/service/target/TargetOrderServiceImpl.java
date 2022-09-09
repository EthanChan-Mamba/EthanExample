package com.ethanChan.springBatchDbExample.service.target;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethanChan.springBatchDbExample.entity.target.TargetOrder;
import com.ethanChan.springBatchDbExample.mapper.target.TargetOrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName OrderServiceImpl.java
 * @Description TODO
 * @createTime 2022-09-08 15:35
 */
@Service
public class TargetOrderServiceImpl extends ServiceImpl<TargetOrderMapper, TargetOrder> implements IService<TargetOrder> {

    @DS("slave")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean saveOrUpdateBatchSlava(List<TargetOrder> targetOrderList) {
        return saveBatch(targetOrderList);
    }


    @DS("slave")
    public List<TargetOrder> listSlava() {
        return list();
    }

    @DS("slave")
    @DSTransactional
    public boolean insertSlave(ArrayList<TargetOrder> orders) {
        return saveBatch(orders);
    }
}
