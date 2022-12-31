package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Forum theForum = new Forum();
        Map<Integer, ForumUser> theResultMapOfUsers = theForum.getUserList().stream()
                .filter(forumUser -> forumUser.getUserSex() == 'M')
                .filter(forumUser -> Period.between(forumUser.getUserBirthDate(), LocalDate.now()).getYears() >= 20)
                .filter(forumUser -> forumUser.getUserNumberOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserUniqueID, forumUser -> forumUser));

        System.out.println("# elements: " + theResultMapOfUsers.size());

        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .forEach(System.out::println);

        System.out.println();

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

        /* People class
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') +2 ) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);
         */

        /* BookDirectory
        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);
         */

        /* BookDirectory with Collectors.toList()
        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);
         */

        /*BookDirectory with Collectors.toMap()
        BookDirectory theBookDirectory = new BookDirectory();

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .forEach(System.out::println);
         */

        /*BookDirectory with Collectors.joining()
        BookDirectory theBookDirectory = new BookDirectory();

        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<", ">>" ));

        System.out.println(theResultStringOfBooks);
         */

    }
}
