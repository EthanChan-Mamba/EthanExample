package com.chen.flyweight;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-08 17:19
 */
public class Client {
    public static void main(String[] args) {
        WebsiteFactory websiteFactory = new WebsiteFactory();

        Website website = websiteFactory.getWebSiteCategory("新闻");
        User tom = new User("Tom");
        website.use(tom);
    }
}
