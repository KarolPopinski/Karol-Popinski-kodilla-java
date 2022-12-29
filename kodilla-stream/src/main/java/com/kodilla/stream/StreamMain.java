package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;


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

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String sthText = "Good morning Vietnam!";

        poemBeautifier.beautify(sthText, (text -> "ABC " + text + " ABC"));
        poemBeautifier.beautify(sthText, (text -> text.toUpperCase()));
        poemBeautifier.beautify(sthText, (text -> text.substring(13)));
        poemBeautifier.beautify(sthText, (text -> text.replace("Good", "Gooooooooooooooooooooooood") + " !!!!!!!!!!!"));
    }
}
