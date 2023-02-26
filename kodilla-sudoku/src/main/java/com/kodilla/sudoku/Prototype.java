package com.kodilla.sudoku;

public class Prototype implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Object) super.clone();
    }
}
