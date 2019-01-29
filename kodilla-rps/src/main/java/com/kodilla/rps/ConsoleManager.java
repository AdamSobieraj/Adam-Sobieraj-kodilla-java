package com.kodilla.rps;

import java.util.HashSet;
import java.util.Scanner;

public class ConsoleManager {

    private static Scanner in = new Scanner(System.in);
    private static Scanner inString = new Scanner(System.in);

    public static String gettingConsoleInputString() {
        String input = inString.nextLine();
        return input;
    }

    public static Integer gettingConsoleInputIntiger() {
        Integer input = in.nextInt();
        return input;
    }

    public static void messagePrinter(MenuPrintSelection menuOption){

        switch (menuOption){
            case MAIN_MENU_PRINT:
                System.out.println("1. Add person");
                System.out.println("2. StartGame");
                System.out.println("3. Find person");
                System.out.println("4. Show all players");
                System.out.println("5. Save Added person");
                System.out.println("6. Close program");
                break;
            case ENTER_NAME:
                System.out.println("Enter Name");
                break;
            case ENTER_SURNAME:
                System.out.println("Enter surname: ");
                break;
            case PERSON_EXIST:
                System.out.println("Human Exist");
                break;
            case PROGRAM_EXIT_MESSAGE:
                in.close();
                System.out.println("Exiting Program");
                break;
            case MAIN_MENU_SELECTION_DEFAULT:
                System.out.println("Enter a number from 1 to 4");
                break;
            case NO_USER_SELECTED:
                System.out.println("No user Selected");
                break;
            case TO_HOW_MANY_WINS_QUESTION:
                System.out.println("To how many wins ?: ");
                break;
                default:
                    System.out.println("Error");
                    break;
        }
    }

    public static void hashSetObjectPrinter(HashSet<Human> toPrint){
        System.out.println(toPrint);
        System.out.println();
    }

    public static void objectPrinter(Object o){
        System.out.println(o);
        System.out.println();
    }

    public static void gamePrinter(GamePrintSelection gameOption){

        switch (gameOption){
            case GAME_MENU_PRINT_LOGO_PRINT:
                System.out.println();
                System.out.println("=========================================");
                System.out.println("******Gra Papier, Kamien, Nozyczki*******");
                System.out.println("=========================================");
                System.out.println();
                break;
            case GAME_MENU_PRINT_OPTIONS:
                System.out.println("1 - zagranie Kamien");
                System.out.println("2 - zagranie Papier");
                System.out.println("3 - zagranie Nozyce");
                System.out.println("x - exit");
                System.out.println("n - od nowa");
                break;
            case GAME_MENU_PRINT_SUBMENU_OPTIONS:
                System.out.println("s - start game");
                System.out.println("x - exit");
                break;
            case GAME_MENU_PRINT_INPUT_DATA:
                System.out.println("Do Ilu Zwyciestw: ");
                break;
        }
    }

    public static void gamePrinterOptions(GamePrinterOptions gamePrinterOptions){
        switch (gamePrinterOptions){
            case GAME_PRINTER_OPTIONS_KAMIEN:
                System.out.println("Wybrano Kamien");
                break;
            case GAME_PRINTER_OPTIONS_PAPIER:
                System.out.println("Wybrano Papier");
                break;
            case GAME_PRINTER_OPTIONS_NOZYCE:
                System.out.println("Wybrano Nozyce");
                break;
            case GAME_PRINTER_OPTIONS_NEW:
                System.out.println("Reset Licznika");
                break;
            case GAME_PRINTER_OPTIONS_EXIT:
                System.out.println("Exit");
                break;
            case GAME_PRINTER_OPTIONS_PLAYER_1:
                System.out.println("Player 1 Option");
                break;
            case GAME_PRINTER_OPTIONS_PLAYER_2:
                System.out.println("Player 2 option");
                break;
            case GAME_PRINTER_OPTIONS_WINS:
                System.out.println("Winst Statistic: ");
                break;
            case GAME_PRINTER_OPTIONS_LOST:
                System.out.println("Lost Statistic: ");
                break;
            case GAME_PRINTER_OPTIONS_REMIS:
                System.out.println("Remis Statistic: ");
                break;
        }

    }

}
