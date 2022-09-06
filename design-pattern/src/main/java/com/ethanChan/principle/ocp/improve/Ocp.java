package com.ethanChan.principle.ocp.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Ocp.java
 * @Description TODO
 * @createTime 2022-04-17 17:17
 */
public class Ocp {
    public static void main(String[] args) {

    }
}

class GraphicEditor {
    public void drawShape(Shape s) {
        s.draw();
    }

}

// 基类
abstract class Shape {
    int m_type;

    public abstract void draw();
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {

    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {

    }
}
