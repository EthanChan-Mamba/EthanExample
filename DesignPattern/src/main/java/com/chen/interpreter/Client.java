package com.chen.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-13 11:20
 */
public class Client {
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr();
        HashMap<String, Integer> value = getValue(expStr);
        Calculator calculator = new Calculator(expStr);
        System.out.println(calculator.run(value));
    }
    // 获得表达式
    public static String getExpStr() throws IOException {
        System.out.print("请输入表达式 ");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    // ∥获得值映射
    public static HashMap<String,Integer> getValue(String expStr)throws IOException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (char ch : expStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                if (!map.containsKey(String.valueOf(ch))) {
                    System.out.print("请输入" + String.valueOf(ch) + "的值：");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                    return map;
                }
            }
        }
        return map;
    }
}
