package com.chen.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName WebsiteFactory.java
 * @Description 网站工厂类，根据需要返回网站
 * @createTime 2022-05-08 17:15
 */
public class WebsiteFactory {

    // 集合，池
    private Map<String, ConcreteWebsite> pool = new HashMap<String, ConcreteWebsite>();

    // 根据网站类型，返回；如果没有就创建一个，并放入池中，并返回
    public Website getWebSiteCategory(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebsite(type));
        }

        return pool.get(type);
    }
}
