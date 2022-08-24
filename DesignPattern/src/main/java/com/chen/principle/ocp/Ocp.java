package com.chen.principle.ocp;

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
        if (s.m_type == 1) {
            drawRectangle(s);
        } else if (s.m_type == 2) {
            drawCircle(s);
        }
    }

    public void drawRectangle(Shape r) {
        System.out.println("");
    }
    public void drawCircle(Shape r) {
        System.out.println("");
    }
}

class Shape {
    int m_type;
}

class Rectangle extends Shape{
    Rectangle() {
        super.m_type = 1;
    }
}

class Circle extends Shape{
    Circle() {
        super.m_type = 2;
    }
}
