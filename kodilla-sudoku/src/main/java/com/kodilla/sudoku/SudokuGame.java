package com.kodilla.sudoku;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SudokuGame {

    private final SudokuBoard sudokuBoard = new SudokuBoard();
    private final Scanner scanner = new Scanner(System.in);

    public boolean resolveSudoku() {
        sudokuBoard.printBoard();
        fillSudoku();
        solution();
        return true;
    }

    private void solution() {
        do {
            System.out.println("Please write the word 'sudoku' for the solution");
        } while (!scanner.nextLine().equals("sudoku"));

        try {
            SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(sudokuBoard);
            SudokuBoard result = sudokuAlgorithm.solve();
            System.out.println(result);
        } catch (CloneNotSupportedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    private void fillSudoku() {
        System.out.println("Welcome to Sudoku Task");
        System.out.println(sudokuBoard);
        List<String> inputList = SudokuSevice.getInput();
        for (String input : inputList) {
            sudokuBoard.addToSudoku(Character.getNumericValue(input.charAt(0)), Character.getNumericValue(input.charAt(1)),
                    Character.getNumericValue(input.charAt(2)));
            System.out.println(sudokuBoard);
        }
    }

}
