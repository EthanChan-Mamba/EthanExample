package com.ethanChan.redisGeoExample.controller;

import com.ethanChan.redisGeoExample.data.Rest;
import com.ethanChan.redisGeoExample.data.RestBody;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The type Location controller.
 *
 * @author felord.cn
 * @since 16 :01
 */
@RestController
@RequestMapping("/app/v1/loc")
public class LocationController {
    @Resource
    private BoundGeoOperations<String, String> citiesGeoOps;


    /**
     * Dis rest.
     * http://localhost:8085/app/v1/loc/radius?limit=5&rad=200&x=115.03&y=38.44
     *
     * @param x     经度
     * @param y     纬度
     * @param rad   半径
     * @param limit 条数
     * @return the rest
     */
    @GetMapping("/radius")
    public Rest<GeoResults<RedisGeoCommands.GeoLocation<String>>> dis(Double x, Double y, Double rad, @RequestParam(defaultValue = "5") Long limit) {

        Point point = new Point(x, y);
        Metric metric = RedisGeoCommands.DistanceUnit.KILOMETERS;
        Distance distance = new Distance(rad, metric);
        Circle circle = new Circle(point, distance);

        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands
                .GeoRadiusCommandArgs
                .newGeoRadiusArgs()
                .includeDistance()
                .includeCoordinates()
                .sortAscending()
                .limit(limit);
        return RestBody.okData(citiesGeoOps.radius(circle, args));
    }


}
