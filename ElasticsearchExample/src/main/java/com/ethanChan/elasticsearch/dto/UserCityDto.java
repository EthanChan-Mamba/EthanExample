package com.ethanChan.elasticsearch.dto;

import lombok.Data;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName UserCityDto.java
 * @Description TODO
 * @createTime 2022-08-28 23:25
 */
@Data
public class UserCityDto {
    /**
     * 城市
     */
    private String city;
    /**
     * 用户数
     */
    private Long count;
    /**
     * 平均年龄
     */
    private Double avgAge;
}
