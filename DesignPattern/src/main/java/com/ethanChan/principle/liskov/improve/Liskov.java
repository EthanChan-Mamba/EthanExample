package com.ethanChan.principle.liskov.improve;

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

// 更基础的类
class Base {

}

class A extends Base{
    public int func1(int a, int b) {
        return a + b;
    }
}

class B extends Base {
    // 如果B要用A的方法，用组合方式
    private A a= new A();
    public int fun1(int a, int b) {
        return a - b;
    }

    public int fun2(int a, int b) {
        return fun1(a, b) + 1;
    }

    public int fun3(int a, int b) {
        return this.a.func1(a, b);
    }
}
