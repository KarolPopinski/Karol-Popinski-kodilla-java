package com.kodilla.testing.shape;

public class Circle implements Shape {

    String shapeName;
    double field;

    public Circle(double radius) {
        this.shapeName = "circle";
        this.field = Math.PI*radius*radius;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() {
        return field;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "shapeName='" + shapeName + '\'' +
                ", field=" + field +
                '}';
    }
}
