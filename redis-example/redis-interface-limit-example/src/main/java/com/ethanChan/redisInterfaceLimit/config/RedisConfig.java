package com.ethanChan.redisInterfaceLimit.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;

import javax.annotation.Resource;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName RedisConfig.java
 * @Description
 * 默认的 RedisTemplate 有一个小坑，就是序列化用的是 JdkSerializationRedisSerializer
 * 直接用这个序列化工具将来存到 Redis 上的 key 和 value 都会莫名其妙多一些前缀，这就导致你用命令读取的时候可能会出错。
 * 例如存储的时候，key 是 name，value 是 javaboy，但是当你在命令行操作的时候，get name 却获取不到你想要的数据
 *   ，原因就是存到 redis 之后 name 前面多了一些字符，此时只能继续使用 RedisTemplate 将之读取出来。
 * 会用到 Lua 脚本，使用 Lua 脚本的时候，就会出现上面说的这种情况，所以我们需要修改 RedisTemplate 的序列化方案
 * @createTime 2022-06-09 10:11
 */
@Configuration
public class RedisConfig {
    @Resource
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 使用Jackson2JsonRedisSerialize 替换默认序列化(默认采用的是JDK序列化)
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }

    /**
     * 加载这段 Lua 脚本
     *
     * KEYS 和 ARGV 都是一会调用时候传进来的参数，tonumber 就是把字符串转为数字，redis.call 就是执行具体的 redis 指令，具体流程是这样：
     * 1. 首先获取到传进来的 key 以及 限流的 count 和时间 time。
     * 2. 通过 get 获取到这个 key 对应的值，这个值就是当前时间窗内这个接口可以访问多少次。
     * 3. 如果是第一次访问，此时拿到的结果为 nil，否则拿到的结果应该是一个数字
     *      ，所以接下来就判断，如果拿到的结果是一个数字，并且这个数字还大于 count，那就说明已经超过流量限制了，那么直接返回查询的结果即可。
     * 4. 如果拿到的结果为 nil，说明是第一次访问，此时就给当前 key 自增 1，然后设置一个过期时间。
     * 5. 最后把自增 1 后的值返回就可以了。
     * @return
     */
    @Bean
    public DefaultRedisScript<Long> limitScript() {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/limit.lua")));
        redisScript.setResultType(Long.class);
        return redisScript;
    }
}
