package com.kodilla.rps;

import static com.kodilla.rps.ConsoleManager.*;
import static com.kodilla.rps.GamePrintSelection.*;
import static com.kodilla.rps.GamePrinterOptions.*;

public class GameControll {

    private int hoiceOfPC;
    private int choiceOfThePlayer;
    private int gameTry;
    private int wingInGame;
    private int failsInGame;
    private int remisInGame;
    private int gameCounter;
    private String choice;
    private String menuSubChoice;
    private RandNumber randNumber = new RandNumber(3);

    public void runGame(){
        GameMenuSelection menuChoice = showMainMenuSelection();
        switch (menuChoice){
            case GAME_MENU_SELECTION_START_GAME:
                gameRun();
                break;
            case GAME_MENU_SELECTION_EXIT:
                gamePrinter(GAME_MENU_PRINT_PROGRAM_EXIT_MESSAGE_GAME);
                System.exit(0);
                break;
        }
    }

    private GameMenuSelection showMainMenuSelection(){
        do{
            gamePrinter(GAME_MENU_PRINT_LOGO_PRINT);
            gamePrinter(GAME_MENU_PRINT_SUBMENU_OPTIONS);
            menuSubChoice = gettingConsoleInputString();
            switch (menuSubChoice) {
                case "s": return GameMenuSelection.GAME_MENU_SELECTION_START_GAME;
                case "x": return GameMenuSelection.GAME_MENU_SELECTION_EXIT;
                default:
                    gamePrinter(GAME_MENU_PRINT_SELECTION_DEFAULT);
            }
        }while(menuSubChoice.equals("x"));
        return null;
    }

private void gameRun(){

    gamePrinter(GAME_MENU_PRINT_LOGO_PRINT);
    gamePrinter(GAME_MENU_PRINT_INPUT_DATA);
    gameTry = gettingConsoleInputIntiger();

    while(!choice.equals("x")||(gameCounter>gameTry)) {
        gamePrinter(GAME_MENU_PRINT_LOGO_PRINT);
        GameOptions playerSelection = playerChoice();
        switch (playerSelection){
            case KAMIEN:
                GamePrinterOptions(GAME_PRINTER_OPTIONS_KAMIEN);
            case NOZYCE:
                GamePrinterOptions(GAME_PRINTER_OPTIONS_NOZYCE);
            case PAPIER:
                GamePrinterOptions(GAME_PRINTER_OPTIONS_PAPIER);
            case NEW:
                GamePrinterOptions(GAME_PRINTER_OPTIONS_NEW);
                wingInGame = 0;
                failsInGame = 0;
                remisInGame = 0;
            case EXIT:
                GamePrinterOptions(GAME_PRINTER_OPTIONS_KAMIEN);
                gamePrinter(GAME_MENU_PRINT_PROGRAM_EXIT_MESSAGE_GAME);
                System.exit(0);
        }

        PCGameChoose pcSelection = pcSelect();
        switch (pcSelection){
            case PC_GAME_CHOOSE_KAMIEN:
                if (playerSelection == GameOptions.NOZYCE){}

        }




    }





}

private GameOptions playerChoice(){
    do{
        gamePrinter(GAME_MENU_PRINT_OPTIONS);
        choice = gettingConsoleInputString();
        switch (Integer.parseInt(choice)) {
            case 1: return GameOptions.KAMIEN;
            case 2: return GameOptions.NOZYCE;
            case 3: return GameOptions.PAPIER;
            case 110: return GameOptions.NEW;
            case 120: return GameOptions.EXIT;
            default:
                gamePrinter(GAME_MENU_PRINT_SELECTION_DEFAULT_SUBMENU);
        }
    }while(menuSubChoice.equals("x"));
    return null;
}

    private PCGameChoose pcSelect(){
        do{
            hoiceOfPC = randNumber.RandomNumberGenerator();
            switch (hoiceOfPC) {
                case 1: return PCGameChoose.PC_GAME_CHOOSE_KAMIEN;
                case 2: return PCGameChoose.PC_GAME_CHOOSE_NOZYCE;
                case 3: return PCGameChoose.PC_GAME_CHOOSE_PAPIER;
                default:
                    gamePrinter(GAME_MENU_PRINT_SELECTION_DEFAULT_SUBMENU);
            }
        }while(menuSubChoice.equals("x"));
        return null;
    }


}
