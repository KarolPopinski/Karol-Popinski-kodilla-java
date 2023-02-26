package com.kodilla.sudoku;

import org.junit.jupiter.api.Test;

class SudokuTestSuite {

    @Test
    void testBoard() {

        SudokuBoard sudokuBoard = new SudokuBoard();

        sudokuBoard.printBoard();
    }
}
