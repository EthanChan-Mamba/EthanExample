package com.ethanChan.shardingMybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethanChan.shardingMybatisPlus.entity.CommunicationInfo;
import com.ethanChan.shardingMybatisPlus.entity.Order;
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
public interface CommunicationInfoMapper extends BaseMapper<CommunicationInfo> {

    @Update({"CREATE TABLE `b_communication_info`  (\n" +
            "  `info_id` int(11),\n" +
            "  `info_account` varchar(50) ,\n" +
            "  `info_name` varchar(50) ,\n" +
            "  `request_no` varchar(50) ,\n" +
            "  `deskey` varchar(100) ,\n" +
            "  `public_key` varchar(255) ,\n" +
            "  `private_key` varchar(1024) ,\n" +
            "  `url` varchar(255) ,\n" +
            "  `remark` varchar(50) ,\n" +
            "  `create_time` datetime(0) ,\n" +
            "  `update_time` datetime(0) ,\n" +
            // "  PRIMARY KEY (`info_id`) USING BTREE\n" +
            ")"})
    void createCommunicationInfo();
}
