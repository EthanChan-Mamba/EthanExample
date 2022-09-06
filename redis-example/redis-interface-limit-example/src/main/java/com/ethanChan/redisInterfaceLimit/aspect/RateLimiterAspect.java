package com.ethanChan.redisInterfaceLimit.aspect;

import com.ethanChan.redisInterfaceLimit.annotion.RateLimiter;
import com.ethanChan.redisInterfaceLimit.domain.LimitType;
import com.ethanChan.redisInterfaceLimit.exception.ServiceException;
import com.ethanChan.redisInterfaceLimit.util.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName RateLimiterAspect.java
 * @Description 这个切面就是拦截所有加了 @RateLimiter 注解的方法，在前置通知中对注解进行处理。
 *
 * 1. 首先获取到注解中的 key、time 以及 count 三个参数。
 * 2. 获取一个组合的 key，所谓的组合的 key，就是在注解的 key 属性基础上，再加上方法的完整路径
 *      ，如果是 IP 模式的话，就再加上 IP 地址。以 IP 模式为例，
 *      最终生成的 key 类似这样：rate_limit:127.0.0.1-org.javaboy.ratelimiter.controller.HelloController-hello
 *      （如果不是 IP 模式，那么生成的 key 中就不包含 IP 地址）。
 * 3. 将生成的 key 放到集合中。
 * 4. 通过 redisTemplate.execute 方法取执行一个 Lua 脚本
 * ，第一个参数是脚本所封装的对象，第二个参数是 key，对应了脚本中的 KEYS，后面是可变长度的参数，对应了脚本中的 ARGV。
 * 5. 将 Lua 脚本执行的结果与 count 进行比较，如果大于 count，就说明过载了，抛异常就行了。
 * @createTime 2022-06-09 13:45
 */
@Aspect
@Component
public class RateLimiterAspect {
    private static final Logger log = LoggerFactory.getLogger(RateLimiterAspect.class);

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private RedisScript<Long> limitScript;

    @Before("@annotation(rateLimiter)")
    public void doBefore(JoinPoint point, RateLimiter rateLimiter) throws Throwable {
        String key = rateLimiter.key();
        int time = rateLimiter.time();
        int count = rateLimiter.count();

        String combineKey = getCombineKey(rateLimiter, point);
        List<Object> keys = Collections.singletonList(combineKey);
        try {
            Long number = redisTemplate.execute(limitScript, keys, count, time);
            if (number==null || number.intValue() > count) {
                throw new ServiceException("访问过于频繁，请稍候再试");
            }
            log.info("限制请求'{}',当前请求'{}',缓存key'{}'", count, number.intValue(), key);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("服务器限流异常，请稍候再试");
        }
    }

    public String getCombineKey(RateLimiter rateLimiter, JoinPoint point) {
        StringBuffer stringBuffer = new StringBuffer(rateLimiter.key());
        if (rateLimiter.limitType() == LimitType.IP) {
            stringBuffer.append(IpUtils.getIpAddress(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest())).append("-");
        }
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        stringBuffer.append(targetClass.getName()).append("-").append(method.getName());
        return stringBuffer.toString();
    }
}
