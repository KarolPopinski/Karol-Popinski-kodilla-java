package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SudokuSevice {

    private final static Scanner scanner = new Scanner(System.in);

    public SudokuSevice() {
    }
    public static List<String> getInput() {
        List<String> inputList = new ArrayList<>();
        System.out.println("Please insert your choice only by numeric keyboard!");
        System.out.println("Example: 789 -> 7 is ROW | 8 is Column | and 9 is value");
        System.out.println();
        inputList.add(checkNumber(scanner.nextLine()));
        return inputNext(inputList);
    }

    public static List<String> inputNext(List<String> inputList) {
        System.out.println("Please insert Your next choice -> example '789' or press 'n' for next step " +
                "and finish the game");
        String input = scanner.nextLine();
        while (!input.equals("n")) {
            inputList.add(checkNumber(input));
            System.out.println("Please insert Your next choice -> example '789' or press 'n' for next step " +
                    "and finish the game");
            input = scanner.nextLine();
        }
        return inputList;
    }

    public static String checkNumber(String text) {
        while (!text.matches("-?[1-9]{3}")) {
            System.out.println("wrong input: use only number from 1 to 9");
            text = scanner.nextLine();
        }
        return text;
    }
}
