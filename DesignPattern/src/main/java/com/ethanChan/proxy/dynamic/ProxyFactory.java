package com.ethanChan.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName ProxyFactory.java
 * @Description TODO
 * @createTime 2022-05-14 23:19
 */
public class ProxyFactory {

    // 维护一个目标对象，
    private Object target;

    // 对factory初始化
    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 给目标对象，生成一个代理对象
    public Object getProxyInstance() {
        // 1. 指定目标对象使用的类加载器，获取加载器的方法固定
        // 2. 目标对象实现的接口类型，使用泛型方法确认类型
        // 3. 事情处理，执行目标对象的方法时，会触发事情处理器方法，会把当前执行的目标对象方法作为参数传入
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces()
                , new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK代理开始");
                        Object returnVal = method.invoke(target, args);
                        return returnVal;
                    }
                });
    }
}
