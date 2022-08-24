package com.chen.redisGeoExample.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Geo redis configuration.
 *
 * @author felord.cn
 * @since 15 :55
 */
@Configuration
public class GeoRedisConfiguration {
    /**
     * The constant GEO_STAGE.
     */
    public static final String GEO_STAGE = "cities:locs";


    /**
     * Geo ops bound geo operations.
     *
     * @param redisTemplate the redis template
     * @return the bound geo operations
     */
    @Bean
    public BoundGeoOperations<String, String> citiesGeoOps(RedisTemplate<String, String> redisTemplate) {
        // 清理缓存
        redisTemplate.delete(GEO_STAGE);
        return redisTemplate.boundGeoOps(GEO_STAGE);
    }


    /**
     * 初始化地理位置.
     *
     * @param geoOps the geo ops
     * @return the application runner
     */
    @Bean
    public ApplicationRunner cacheActiveAppRunner(@Qualifier("citiesGeoOps") BoundGeoOperations<String, String> geoOps) {

        return args -> {

            Map<String, Point> points = new HashMap<>();
            points.put("tianjin", new Point(117.12, 39.08));
            points.put("shijiazhuang", new Point(114.29, 38.02));
            // RedisTemplate 批量添加 GeoLocation
            geoOps.add(points);
        };
    }

}
