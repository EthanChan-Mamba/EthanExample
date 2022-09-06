package com.ethanChan.redisInterfaceLimit.domain;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName LimitType.java
 * @Description 1. 针对当前接口的全局性限流，例如该接口可以在 1 分钟内访问 100 次。
 *              2. 针对某一个 IP 地址的限流，例如某个 IP 地址可以在 1 分钟内访问 100 次。
 * @createTime 2022-06-09 09:56
 */
public enum LimitType {
    /**
     * 默认策略全局限流
     */
    DEFAULT,
    /**
     * 根据请求者IP进行限流
     */
    IP
}
