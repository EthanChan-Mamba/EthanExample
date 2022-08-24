package com.chen.interpreter;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Calculator.java
 * @Description TODO
 * @createTime 2022-05-13 10:57
 */
public class Calculator {

    private Expression expression;

    public Calculator(String expStr) {
        // 安排运算先后顺序
        Stack<Expression> stack = new Stack<Expression>();
        // 表达式拆分成字符数组 [ a + b]
        char[] charArray = expStr.toCharArray();

        Expression left = null;
        Expression right = null;

        // 遍历字符数组
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    left = stack.pop();
                    // 取出右表达式
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    // 获取left,right构建AddExpression, 加入stack
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    // 取出右表达式
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    // 如果是var
                    stack.push(new VarExpression(String.valueOf(charArray[++i])));
                    break;
            }
        }
        // 遍历完，得到最后Expression
        this.expression = stack.pop();
    }

    public int run(HashMap<String, Integer> var) {
        // 最后将表达式a+b和var = {a=10, b=20}传给expression和interpreter执行
        return this.expression.interperter(var);
    }
}
