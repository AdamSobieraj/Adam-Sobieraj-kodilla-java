package com.kodilla.rps;

import java.util.HashSet;

import static com.kodilla.rps.ConsoleManager.*;
import static com.kodilla.rps.ConsoleManager.objectPrinter;
import static com.kodilla.rps.MenuPrintSelection.*;
import static com.kodilla.rps.OpenCSVReadWrite.*;

public class Game {

    private HashSet<Person> people = new HashSet<Person>();
    private Person currentGamePlayer;

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

        while (true){
            if (currentGamePlayer == null){
                messagePrinter(NO_USER_SELECTED);
            }else{
                objectPrinter(currentGamePlayer);
            }
            MenuAction action = showMainMenuSelection();
            switch (action){
                case ADD_PERSON:
                    Person newPerson = getPerInformation();
                    if (people.contains(newPerson)){ messagePrinter(PERSON_EXIST); }
                    people.add(newPerson);
                    break;
                case START_GAME:
                    /////
                    break;
                case FIND_PERSON:
                    findPersonPlayerOne(people);
                    break;
                case DISPLAY_ALL_PLAYERS:
                    for (Person personFromFile: readWithOpenCSV()){
                        people.add(personFromFile);
                    }
                    hashSetObjectPrinter(people);
                    break;
                case SAVE_BOOK_LIST:
                    wtriteWithOpenCSV(people);
                    break;
                case EXIT:
                    messagePrinter(PROGRAM_EXIT_MESSAGE);
                    System.exit(0);
                    break;
            }
        }
    }

    private Person getPerInformation(){
        messagePrinter(ENTER_NAME);
        String perName = gettingConsoleInputString();
        messagePrinter(ENTER_SURNAME);
        String surname = gettingConsoleInputString();
        String score = "0";

        return new Person(perName , surname,score);
    }

    private void findPersonPlayerOne(HashSet<Person> currentPlayer){

        messagePrinter(ENTER_NAME);
        String playerName = gettingConsoleInputString();
        messagePrinter(ENTER_SURNAME);
        String playerSurname = gettingConsoleInputString();

        for (Person currPL: people){
            if (playerName.equals(currPL.getName())&&playerSurname.equals(currPL.getSurname())){
                currentGamePlayer = new Person(currPL.getName(), currPL.getSurname(), currPL.getScore());
            }
        }

    }

}
