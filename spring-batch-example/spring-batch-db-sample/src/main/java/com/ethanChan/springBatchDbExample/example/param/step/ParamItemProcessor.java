package com.ethanChan.springBatchDbExample.example.param.step;

import com.ethanChan.springBatchDbExample.common.LogConstants;
import com.ethanChan.springBatchDbExample.entity.origin.Order;
import com.ethanChan.springBatchDbExample.entity.target.TargetOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * 处理类
 * @author mason
 * @since 2019/6/1
 **/
@Slf4j
public class ParamItemProcessor implements ItemProcessor<Order, TargetOrder> {

    @Override
    public TargetOrder process(Order user) {
        String title = user.getName();
        if(Objects.nonNull(title)){
            user.setName(title.toUpperCase());
        }
        log.info(LogConstants.LOG_TAG + "db item process: " +user.getName());
        TargetOrder targetUser = new TargetOrder();
        BeanUtils.copyProperties(user,targetUser);
        return targetUser;
    }
}
