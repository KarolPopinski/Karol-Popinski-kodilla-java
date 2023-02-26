package com.kodilla.sudoku;

public class SudokuAlgorithm {

    private final SudokuBoard backtrackBoard;

    public SudokuAlgorithm(SudokuBoard sudokuBoard) throws CloneNotSupportedException {
        this.backtrackBoard = sudokuBoard.deepCopy();
    }
    public SudokuBoard solve() throws CloneNotSupportedException {
        if (!solveBoard()) {
            throw new IllegalArgumentException("FATAL: Sudoku is not possible to solve");
        }
        return backtrackBoard.deepCopy();
    }

    private boolean solveBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (emptyField(i, j)) {
                    return solveField(i, j);
                }
            }
        }
        return true;
    }

    private boolean solveField(int x, int y) {
        for (int z = 1; z < 10; z++) {
            if (possibleFill(x, y, z)) {
                backtrackBoard.getGameBoard().get(x).getSudokuRows().get(y).setValue(z);
                if (solveBoard()) {
                    return true;
                }
                backtrackBoard.getGameBoard().get(x).getSudokuRows().get(y).setValue(SudokuElement.EMPTY);
            }
        }
        return false;
    }

    private boolean possibleFill(int x, int y, int value) {
        return possibleLine(x, y, value) && possibleField(x, y, value);
    }

    private boolean possibleField(int x, int y, int value) {
        int firstX = x - x % 3;
        int firstY = y -y % 3;
        for (int i = 0; i <3; i++) {
            for (int j = 0; j < 3; j++) {
                if (backtrackBoard.getGameBoard().get(firstX + i).getSudokuRows().get(firstY + i).getValue() == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean possibleLine(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (backtrackBoard.getGameBoard().get(i).getSudokuRows().get(y).getValue() == value ||
                    backtrackBoard.getGameBoard().get(x).getSudokuRows().get(i).getValue() == value) {
                return false;
            }
        }
        return true;
    }

    private boolean emptyField(int x, int y) {
        return backtrackBoard.getGameBoard().get(x).getSudokuRows().get(y).getValue() == SudokuElement.EMPTY;
    }
}
