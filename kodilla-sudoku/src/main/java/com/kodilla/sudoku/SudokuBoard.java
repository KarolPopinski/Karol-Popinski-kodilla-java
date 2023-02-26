package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype {

    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 8;

    private List<SudokuRow> gameBoard = new ArrayList<>();

    public SudokuBoard() {
    }

    public List<SudokuRow> getGameBoard() {
        return gameBoard;
    }
    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            gameBoard.add(new SudokuRow());
        }
        for (SudokuRow sudokuRow : gameBoard) {
            sudokuRow.getEmptyRow();
        }
    }
    public void addToSudoku(int x, int y, int value) {
        gameBoard.get(x - 1).getSudokuRows().set(y - 1, new SudokuElement(value));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("-------------------");
        result.append("\n");
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            result.append("|");
            for (int j = MIN_INDEX; j <= MAX_INDEX; j++) {
                if (gameBoard.get(i).getSudokuRows().get(j).getValue() == -1) {
                    result.append(" ");
                } else {
                    result.append((gameBoard.get(i).getSudokuRows().get(j).getValue()));
                }
                result.append("|");
            }
            result.append("\n");
            result.append("-------------------");
            result.append("\n");
        }
        return result.toString();
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard backtrackBoard = (SudokuBoard)super.clone();
        backtrackBoard.gameBoard = new ArrayList<>();
        for (SudokuRow sudokuRow : gameBoard) {
            SudokuRow backtrackSudokuRow = new SudokuRow();
            for (SudokuElement sudokuElement : sudokuRow.getSudokuRows()) {
                backtrackSudokuRow.getSudokuRows().add(sudokuElement);
            }
            backtrackBoard.getGameBoard().add(backtrackSudokuRow);
        }
        return backtrackBoard;
    }
}
