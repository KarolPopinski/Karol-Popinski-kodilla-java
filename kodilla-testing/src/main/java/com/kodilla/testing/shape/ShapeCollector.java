package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    public ArrayList<Shape> shapesList = new ArrayList<Shape>();

    public ShapeCollector(ArrayList<Shape> shapesList) {
        this.shapesList = shapesList;
    }

    public void addFigure(Shape shape) {
        shapesList.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapesList.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n < shapesList.size() && n >= 0) {
            return shapesList.get(n);
        } else {
            return null;
        }
    }

    public ArrayList<Shape> showFigures() {
        for (Shape figures : shapesList) {
            System.out.println(figures);
        }
        return shapesList;
    }
    public ArrayList<Shape> getShapesList() {
        return shapesList;
    }

    @Override
    public String toString() {
        return "ShapeCollector{" +
                "shapesList=" + shapesList +
                '}';
    }
}
