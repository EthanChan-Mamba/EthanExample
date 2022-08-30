package com.ethanChan.shardingMybatisPlus.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethanChan.shardingMybatisPlus.entity.CommunicationInfo;
import com.ethanChan.shardingMybatisPlus.mapper.CommunicationInfoMapper;
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
public class CommunicationInfoServiceImpl extends ServiceImpl<CommunicationInfoMapper, CommunicationInfo> implements IService<CommunicationInfo> {

    @Autowired
    CommunicationInfoMapper communicationInfoMapper;

    @DS("slave")
    public void init() {
        communicationInfoMapper.createCommunicationInfo();
    }

    @DS("slave")
    public boolean saveSlave(CommunicationInfo setInfoId) {
        return save(setInfoId);
    }

    @DS("slave")
    public List<CommunicationInfo> listSlave() {
        return list();
    }
}
