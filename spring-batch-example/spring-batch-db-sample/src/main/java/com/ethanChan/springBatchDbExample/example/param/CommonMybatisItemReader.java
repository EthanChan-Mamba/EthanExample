package com.ethanChan.springBatchDbExample.example.param;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName CommonFileItemReader.java
 * @Description 读取数据库公共reader
 * @createTime 2022-09-13 14:31
 */
public class CommonMybatisItemReader<T> extends MyBatisPagingItemReader<T> {

    public CommonMybatisItemReader(SqlSessionFactory sqlSessionFactory, String name) {
        setSqlSessionFactory(sqlSessionFactory);
        setQueryId("com.ethanChan.springBatchDbExample.mapper.oringin."+name+"Mapper.selectList");
        setPageSize(100);
    }
}
