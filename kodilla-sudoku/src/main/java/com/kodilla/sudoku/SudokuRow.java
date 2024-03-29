package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private final List<SudokuElement> sudokuRows = new ArrayList<>();

    public SudokuRow() {
    }
    public List<SudokuElement> getSudokuRows() {
        return sudokuRows;
    }
    public List<SudokuElement> getEmptyRow() {
        for (int i = 0; i < 9; i++) {
            sudokuRows.add(new SudokuElement(SudokuElement.EMPTY));
        }
        return new ArrayList<>(sudokuRows);
    }
}
