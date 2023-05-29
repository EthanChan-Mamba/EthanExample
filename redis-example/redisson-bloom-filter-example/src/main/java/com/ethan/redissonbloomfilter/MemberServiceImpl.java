package com.ethan.redissonbloomfilter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ethan.redissonbloomfilter.entity.Member;
import com.ethan.redissonbloomfilter.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MemberServiceImpl.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-29 14:12
 */
@Service
@Slf4j
public class MemberServiceImpl {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private RedissonClient redisson;

    //基于redission分布式锁下的mybatis-plus数据库查询
    public Map<String,Member> searchByDb(int id){

        Map<String,Member> map = new HashMap<>();
        RLock lock = redisson.getFairLock("myLock");       //获取锁
        try {
            lock.lock();    //上锁
            synchronized (this){
                if(StringUtils.isEmpty(stringRedisTemplate.opsForValue().get("addressList"))){
                    log.info("查数据库");
                    Member address = memberMapper.selectById(id);
                    map.put("placeList",address);
                }else {
                    log.info("缓存击中！");
                    return JSON.parseObject(stringRedisTemplate.opsForValue().get("addressList")
                            , new TypeReference<Map<String, Member>>(){});
                }
            }
        }catch (Exception e){
            log.warn("系统错误，稍后重试");
        }
        finally {
            lock.unlock();    //删除锁
        }

        return map;
    }
    //添加数据
    public int bloomAdd(Member member) {
        //数据库中插入数据
        int result = memberMapper.insert(member);
        //插入成功，存入布隆过滤器中
        if(result > 0){
            //获取布隆过滤器
            RBloomFilter<Object> bloomFilter = redisson.getBloomFilter("idList");
            //初始化布隆过滤器(数据量，误差率)
            bloomFilter.tryInit(1000000L,0.02);
            //往过滤器中加入数据
            bloomFilter.add(member.getId());
        }
        return result;
    }

    //查询
    public Map<String,Member> bloomFilter(int id) {

        //获取布隆过滤器
        RBloomFilter<Object> bloomFilter = redisson.getBloomFilter("idList");
        //判断数据是否在过滤器中
        boolean flag = bloomFilter.contains(id);
        if(flag){
            //存在，查缓存
            String addressList = stringRedisTemplate.opsForValue().get("addressList");
            //判断缓存中是否存在
            if (StringUtils.isEmpty(addressList)){
                log.info("缓存未命中");
                //调用查询数据库的方法
                Map<String,Member> map = searchByDb(id);
                //封装查询结果
                String result = JSON.toJSONString(map);
                //以json格式存入redis中
                stringRedisTemplate.opsForValue().set("addressList",result);
                return map;
            }else {
                log.info("缓存命中");
                //直接返回缓存数据
                return JSON.parseObject(addressList,new TypeReference<Map<String,Member>>(){});
            }
        }else {
            //过滤器不命中，过滤请求、
            log.info("请求被过滤");
            return null;
        }
    }

}
