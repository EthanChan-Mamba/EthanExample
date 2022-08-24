package com.chen.interpreter;

import java.util.HashMap;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName VarExpression.java
 * @Description 变量解释器
 * @createTime 2022-05-13 11:08
 */
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    /**
     *
     * @param var {a=10, b=20}
     * @return 根据变量名称，返回对应值
     */
    @Override
    public int interperter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
