package com.kodilla.stream;

public class StreamMain {

    public static void main(String[] args) {
        /* Calculating with lambdas and reference
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3,4, FunctionalCalculator::divideAByB);*/

        /* Task 7.1 Text beautifier
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String sthText = "Good morning Vietnam!";

        poemBeautifier.beautify(sthText, (text -> "ABC " + text + " ABC"));
        poemBeautifier.beautify(sthText, (text -> text.toUpperCase()));
        poemBeautifier.beautify(sthText, (text -> text.substring(13)));
        poemBeautifier.beautify(sthText, (text -> text.replace("Good", "Gooooooooooooooooooooooood") + " !!!!!!!!!!!"));
         */

        /* first example for Stream use

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
         */

    }
}
