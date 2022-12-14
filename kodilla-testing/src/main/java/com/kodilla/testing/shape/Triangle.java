package com.kodilla.testing.shape;

public class Triangle implements Shape {

    String shapeName;
    double field;

    public Triangle(double sideLength, double height) {
        this.shapeName = "triangle";
        this.field = 0.5 * sideLength * height;
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
        return "Triangle{" +
                "shapeName='" + shapeName + '\'' +
                ", field=" + field +
                '}';
    }
}
