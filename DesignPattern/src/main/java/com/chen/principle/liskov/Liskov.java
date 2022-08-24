package com.chen.principle.liskov;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Liskov.java
 * @Description TODO
 * @createTime 2022-04-17 15:37
 */
public class Liskov {
    public static void main(String[] args) {

    }
}

class A {
    public int func1(int a, int b) {
        return a + b;
    }
}

class B extends A {
    public int fun1(int a, int b) {
        return a - b;
    }

    public int fun2(int a, int b) {
        return fun1(a, b) + 1;
    }
}
