package com.ethanChan.redisInterfaceLimit.annotion;


import com.ethanChan.redisInterfaceLimit.domain.LimitType;

import java.lang.annotation.*;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName RateLimiter.java
 * @Description 哪个接口需要限流，就在哪个接口上添加 @RateLimiter 注解，然后配置相关参数即可
 * @createTime 2022-06-09 10:08
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {
    /**
     * 限流key
     * 前缀，将来完整的 key 是这个前缀再加上接口方法的完整路径，
     *      共同组成限流 key，这个 key 将被存入到 Redis 中
     */
    String key() default "rate_limit:";

    /**
     * 限流时间,单位秒
     */
    int time() default 60;

    /**
     * 限流次数
     */
    int count() default 100;

    /**
     * 限流类型
     */
    LimitType limitType() default LimitType.DEFAULT;
}
