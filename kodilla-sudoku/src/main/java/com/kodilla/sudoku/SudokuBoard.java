package com.kodilla.sudoku;

public class SudokuBoard {

    public static final int ROW = 9;
    public static final int COLUMN = 9;

    private static int[][] sudokuMatrix = new int[COLUMN][ROW];

    private static int column;
    private static int row;
    private static int value;

    public static void sudokuNewBoardFill(int columnn, int roww, int valuee) {
        column = columnn;
        row = roww;
        value = valuee;

    }

    public static int[][] getSudokuMatrix() {
        return sudokuMatrix;
    }
}
