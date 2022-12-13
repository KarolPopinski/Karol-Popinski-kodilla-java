package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int sum = calculator.add(1, 2);
        int subtract = calculator.subtract(50, 25);

        if (sum == 3) {
            System.out.println("OK! for SUM TEST");
        } else {
            System.out.println("Error for SUM TEST");
        }

        if (subtract == 0) {
            System.out.println("OK! for SUBTRACTION TEST");
        } else {
            System.out.println("Error! for SUBTRACTION TEST");
        }
    }
}