package com.ethanChan.elasticsearch.document;

import lombok.Data;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName UserDocument.java
 * @Description TODO
 * @createTime 2022-08-24 18:18
 */
@Data
public class UserDocument {
    private String id;
    private String name;
    private String sex;
    private Integer age;
    private String city;
    // 省略 getter/setter
}
