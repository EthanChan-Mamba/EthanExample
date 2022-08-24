package com.chen.principle.segragation;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Segragation1.java
 * @Description TODO
 * @createTime 2022-04-17 14:39
 */
public class Segragation1 {
    public static void main(String[] args) {

    }
}

interface Interface1 {
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}

class B implements Interface1{

    public void operation1() {

    }

    public void operation2() {

    }

    public void operation3() {

    }

    public void operation4() {

    }

    public void operation5() {

    }
}

class D implements Interface1{

    public void operation1() {

    }

    public void operation2() {

    }

    public void operation3() {

    }

    public void operation4() {

    }

    public void operation5() {

    }
}

//只用1，2，3
class A {
    public void depend1(Interface1 interface1) {
        interface1.operation1();
    }
    public void depend2(Interface1 interface1) {
        interface1.operation2();
    }
    public void depend3(Interface1 interface1) {
        interface1.operation3();
    }
}

//只用1，4，5
class C {
    public void depend1(Interface1 interface1) {
        interface1.operation1();
    }
    public void depend4(Interface1 interface1) {
        interface1.operation4();
    }
    public void depend5(Interface1 interface1) {
        interface1.operation5();
    }
}
