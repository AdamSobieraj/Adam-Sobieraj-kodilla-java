package com.kodilla.rps;

import java.util.HashSet;

import static com.kodilla.rps.ConsoleManager.*;
import static com.kodilla.rps.GamePrintSelection.*;
import static com.kodilla.rps.MenuPrintSelection.*;
import static com.kodilla.rps.OpenCSVReadWrite.*;

public class Game {

    private String perName;
    private String surname;
    private Integer toHowManyWins;

    private HashSet<Human> currentPlayer = new HashSet<>();
    private Human currentGamePlayer;

    private MenuAction showMainMenuSelection() {
        messagePrinter(MAIN_MENU_PRINT);
        String choice;
        do {
            choice = gettingConsoleInputString();
            switch (Integer.parseInt(choice)) {
                case 1: return MenuAction.ADD_PERSON;
                case 2: return MenuAction.START_GAME;
                case 3: return MenuAction.FIND_PERSON;
                case 4: return MenuAction.DISPLAY_ALL_PLAYERS;
                case 5: return MenuAction.SAVE_BOOK_LIST;
                case 6: return MenuAction.EXIT;
                default: messagePrinter(MAIN_MENU_SELECTION_DEFAULT);
            }
        } while (!choice.equals("6"));
        return null;
    }

    //Menu section
    public void menuRun(){

        boolean jumpOutOfMenu = true;
        while (jumpOutOfMenu){
            if (currentGamePlayer == null){
                messagePrinter(NO_USER_SELECTED);
            }else{
                objectPrinter(currentGamePlayer);
            }
            MenuAction action = showMainMenuSelection();
            switch (action){
                case ADD_PERSON:
                    Human newPlayer = getPerInformation();
                    if (currentPlayer.contains(newPlayer)){ messagePrinter(PERSON_EXIST); }
                    currentPlayer.add(newPlayer);
                    break;
                case START_GAME:
                    if (currentGamePlayer == null){
                        messagePrinter(NO_USER_SELECTED);
                    }else{
                        gamePrinter(GAME_MENU_PRINT_LOGO_PRINT);
                        messagePrinter(TO_HOW_MANY_WINS_QUESTION);
                        toHowManyWins = gettingConsoleInputIntiger();
                        jumpOutOfMenu = false;
                    }

                    break;
                case FIND_PERSON:
                    findPersonPlayerOne();
                    break;
                case DISPLAY_ALL_PLAYERS:
                    for (Human personFromFile: readWithOpenCSV()){
                        currentPlayer.add(personFromFile);
                    }
                    hashSetObjectPrinter(currentPlayer);
                    break;
                case SAVE_BOOK_LIST:
                    wtriteWithOpenCSV(currentPlayer);
                    break;
                case EXIT:
                    messagePrinter(PROGRAM_EXIT_MESSAGE);
                    System.exit(0);
                    break;
            }
        }
    }

    private Human getPerInformation(){
        messagePrinter(ENTER_NAME);
        perName = gettingConsoleInputString();
        messagePrinter(ENTER_SURNAME);
        surname = gettingConsoleInputString();
        return new Human(perName , surname);
    }

    private void findPersonPlayerOne(){

        messagePrinter(ENTER_NAME);
        String playerName = gettingConsoleInputString();
        messagePrinter(ENTER_SURNAME);
        String playerSurname = gettingConsoleInputString();

        for (Human currPL: this.currentPlayer){
            if (playerName.equals(currPL.getName())&&playerSurname.equals(currPL.getSurname())){
                currentGamePlayer = new Human(currPL.getName(), currPL.getSurname());
            }
        }
    }

    public String getPerName() {
        return perName;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getToHowManyWins() {
        return toHowManyWins;
    }
}
