package com.kodilla.sudoku;

import static com.kodilla.sudoku.ImputStringConvert.*;
import static com.kodilla.sudoku.Printer.*;

public class Menu {

    private static int userChoice;
    private static boolean gameFinished = false;
    private static SudokuBoard sudokuBoard = new SudokuBoard();
    private static ImputStringConvert convert = new ImputStringConvert();

    public static void programMenu() {

        mainMenuPrinter();
        userChoice = gettingConsoleImputIntiger();

        switch (userChoice) {

            case 1:
                gameStart();
                break;
            case 2:
                System.exit(0);
                break;

            default:
                break;

        }

    }

    public static void gameStart() {
        while (!gameFinished) {

            gamePrint();
            String userInput = gettingConsoleImputString();

            if (userInput != "SUDOKU"){
                convert(userInput);

                sudokuBoard.sudokuNewBoardFill(convert.getColumn(), convert.getRow(), convert.getValue());
            }else {
                SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(sudokuBoard.getSudokuMatrix());
                sudokuDisplay(sudokuAlgorithm.getBoard());

                if (sudokuAlgorithm.solver()){
                    solved();
                    sudokuDisplay(sudokuAlgorithm.getBoard());
                }else {
                    error();
                }
            }



        }


    }
}
