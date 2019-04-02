package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.kodilla.sudoku.Printer.error;
import static com.kodilla.sudoku.Printer.solved;
import static com.kodilla.sudoku.Printer.sudokuDisplay;

public class SudokuTest {

        public static int[][] GRID_TO_SOLVE = {

                {9,0,0,1,0,0,0,0,5},
                {0,0,5,0,9,0,2,0,1},
                {8,0,0,0,4,0,0,0,0},
                {0,0,0,0,8,0,0,0,0},
                {0,0,0,7,0,0,0,0,0},
                {0,0,0,0,2,6,0,0,9},
                {2,0,0,3,0,0,0,0,6},
                {0,0,0,2,0,0,9,0,0},
                {0,0,1,9,0,4,5,7,0},

        };

    public static int[][] GRID_RES = {
            {9,3,4,1,7,2,6,8,5},
            {7,6,5,8,9,3,2,4,1},
            {8,1,2,6,4,5,3,9,7},
            {4,2,9,5,8,1,7,6,3},
            {6,5,8,7,3,9,1,2,4},
            {1,7,3,4,2,6,8,5,9},
            {2,9,7,3,5,8,4,1,6},
            {5,4,6,2,1,7,9,3,8},
            {3,8,1,9,6,4,5,7,2},
    };


    @Test
    public void testConnect(){
        //Given
        //When
        SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(GRID_TO_SOLVE);
        sudokuDisplay(sudokuAlgorithm.getBoard());


        if (sudokuAlgorithm.solver()){
            solved();
            sudokuDisplay(sudokuAlgorithm.getBoard());
        }else {
            error();
        }



        sudokuDisplay(sudokuAlgorithm.getBoard());
        //Then
        Assert.assertArrayEquals(GRID_RES,sudokuAlgorithm.getBoard());
    }
}
