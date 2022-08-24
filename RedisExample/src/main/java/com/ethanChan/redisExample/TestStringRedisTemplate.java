package com.ethanChan.redisExample;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName testStringRedisTemplate.java
 * @Description TODO
 * @createTime 2022-08-22 10:59
 */
public class TestStringRedisTemplate {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void testStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("hello","world_" + UUID.randomUUID().toString());
        String hello = stringRedisTemplate.opsForValue().get("hello");
        System.out.println("保存的数据是：" + hello);
    }
}
