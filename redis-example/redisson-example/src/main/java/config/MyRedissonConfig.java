package config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @ClassName config.MyRedissonConfig.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2022-12-16 17:42
 */
@Configuration
public class MyRedissonConfig {
    /**
     * 对 Redisson 的使用都是通过 RedissonClient 对象
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod="shutdown") // 服务停止后调用 shutdown 方法。
    public RedissonClient redisson() throws IOException {
        // 1.创建配置
        Config config = new Config();
        // 集群模式
        // config.useClusterServers().addNodeAddress("127.0.0.1:7004", "127.0.0.1:7001");
        // 2.根据 Config 创建出 RedissonClient 示例。
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);
    }
}
