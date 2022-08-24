package com.chen.interpreter;

import java.util.HashMap;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SymbolExpression.java
 * @Description 抽象运算符号解析器 这里，每个运算符号，都只和自己左右两个数字有关系，
 *              但左右两个数字有可能也是一个解析的结果，无论何种类型，都是Expression类的实现类
 * @createTime 2022-05-13 11:05
 */
public class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    // 具体由子类实现，默认实现
    @Override
    public int interperter(HashMap<String, Integer> var) {
        return 0;
    }
}
