package com.ethanChan.interpreter;

import java.util.HashMap;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName AddExpression.java
 * @Description 减法解释器
 * @createTime 2022-05-13 11:11
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    /**
     *
     * @param var {a=10, b=20}
     * @return
     */
    public int interpreter(HashMap<String, Integer> var) {
        // 返回表达式对应值
        return super.left.interperter(var) - super.right.interperter(var);
    }
}
