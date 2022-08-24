package com.chen.interpreter;

import java.util.HashMap;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Expression.java
 * @Description TODO
 * @createTime 2022-05-13 10:58
 */
public abstract class Expression {

    // a + b + c
    // 解释公式和数值，key就是公式 参数[a, b , c]，value是具体值
    // HashMap {a=10, b=20}
    public abstract int interperter(HashMap<String , Integer> var);
}
