package controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName TestController.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-18 23:05
 */
public class TestController {

    @Autowired
    RedissonClient redisson;

    @ResponseBody
    @GetMapping("test-lock")
    public String TestLock() {
        // 1.获取锁，只要锁的名字一样，获取到的锁就是同一把锁。
        RLock lock = redisson.getLock("WuKong-lock");

        // 2.加锁
        lock.lock();
        try {
            System.out.println("加锁成功，执行后续代码。线程 ID：" + Thread.currentThread().getId());
            Thread.sleep(10000);
        } catch (Exception e) {
            //TODO
        } finally {
            lock.unlock();
            // 3.解锁
            System.out.println("Finally，释放锁成功。线程 ID：" + Thread.currentThread().getId());
        }

        return "test lock ok";
    }
}
