package com.ethanChan.springBatchDbExample.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.ethanChan.springBatchDbExample.util.SpringContextUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName ExcelOperateServiceImpl.java
 * @Description TODO
 * @createTime 2022-09-13 15:19
 */

@Service
public class ExcelOperateServiceImpl {
    /**
     * 获取bean对应的mapper类
     * @param bean 数据实体类
     * @return  mapperServiceBean
     */
    private Object getMapperServiceBean(Class<?> bean){
        Object mapperServiceBean =null;
        //1、获取mapper的class
        //SqlHelper.table 取得mybatis-plus的TableInfo：mapper、表、主键、字段
        String mapperPath = SqlHelper.table(bean).getCurrentNamespace();
        Class<?> dataMapperClass = null;
        try {
            dataMapperClass = Class.forName(mapperPath);
            mapperServiceBean = SpringContextUtil.getBean(dataMapperClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mapperServiceBean;
    }

    /**
     * 构造查询方法
     * name ：like;
     *
     * @param ew
     */
    private void getQueryWrapper(QueryWrapper ew){

    }

    /**
     * 单个保存方法
     * @param bean  数据实体类
     * @param dataBean  实体类数据
     * @return
     */
    public boolean commonMapperSave(Class<?> bean, Object dataBean) {
        //获取serviceBean
        Object mapperServiceBean = getMapperServiceBean(bean);
        try {
            //3、反射工具类：获取操作方法（参数：class类、方法名称、参数类型）
            Method mapperServiceBeanMethod = ReflectionUtils.findMethod(mapperServiceBean.getClass(), "insert", Object.class);
            //4、反射工具类：执行操作方法（参数：操作方法、执行方法对象、参数值）
            ReflectionUtils.invokeMethod(mapperServiceBeanMethod, mapperServiceBean, dataBean);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Transactional
    public boolean commonMapperBatchSave(Class<?> bean, List<Object> list) {
        //获取serviceBean
        Object mapperServiceBean = getMapperServiceBean(bean);
        try {
            //3、反射工具类：获取操作方法（参数：class类、方法名称、参数类型）
            Method mapperServiceBeanMethod = ReflectionUtils.findMethod(mapperServiceBean.getClass(), "insert", Object.class);
            //4、反射工具类：执行操作方法（参数：操作方法、执行方法对象、参数值）
            for(Object dataBean:list){
                ReflectionUtils.invokeMethod(mapperServiceBeanMethod, mapperServiceBean, dataBean);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<Object> commonMapperSelect(Class<?> bean) {
        //获取serviceBean
        Object mapperServiceBean = getMapperServiceBean(bean);
        try {
            QueryWrapper ew = new QueryWrapper();
            // ew.setEntity(bean);//???
            //构造查询条件
            // ????
            Method mapperServiceBeanMethod = ReflectionUtils.findMethod(mapperServiceBean.getClass(), "selectList", Wrapper.class);
            // 执行方法
            Object obj = ReflectionUtils.invokeMethod(mapperServiceBeanMethod, mapperServiceBean, ew);
            if(obj!=null){
                return (List<Object>)obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
