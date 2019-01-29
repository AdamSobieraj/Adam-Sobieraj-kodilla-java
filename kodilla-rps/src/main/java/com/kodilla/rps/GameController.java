package com.kodilla.rps;

import static com.kodilla.rps.ConsoleManager.*;
import static com.kodilla.rps.GamePrintSelection.*;
import static com.kodilla.rps.GamePrinterOptions.*;

public class GameController {

    private Player player1;
    private Player player2;
    private String userImput;
    private Integer playerOption;
    private int remis;
    private boolean gameBreak;

    private GameRules game;

    private int endGamePoints;

    public GameController(Player player1, Player player2, GameRules game, int endGamePoints) {
        this.player1 = player1;
        this.player2 = player2;
        this.game = game;
        this.endGamePoints = endGamePoints;
    }

    public void runGame(){

        do {
            gamePrinter(GAME_MENU_PRINT_LOGO_PRINT);
            gamePrinter(GAME_MENU_PRINT_OPTIONS);

            userImput = gettingConsoleInputString();
            if (userImput.equals("x")){
                gameBreak = true;
            }else if (userImput.equals("n")){
                player1.setPoint(0);
                player2.setPoint(0);
                gameBreak = false;
            }else{
                playerOption = Integer.parseInt(userImput);
            }

            player1.setMove(playerOption);

            int player1Move = player1.getMove();
            int player2Move = player2.getMove();

            int whoWin = game.whoWin(player1Move,player2Move);

            switch (player1Move){
                case 1:
                    gamePrinterOptions(GAME_PRINTER_OPTIONS_PAPIER);
                    gamePrinterOptions(GAME_PRINTER_OPTIONS_PLAYER_1);
                    break;
                case 2:
                    gamePrinterOptions(GAME_PRINTER_OPTIONS_KAMIEN);
                    gamePrinterOptions(GAME_PRINTER_OPTIONS_PLAYER_1);
                    break;
                case 3:
                    gamePrinterOptions(GAME_PRINTER_OPTIONS_NOZYCE);
                    gamePrinterOptions(GAME_PRINTER_OPTIONS_PLAYER_1);
                    break;
            }

            switch (player2Move){
                case 1:
                    gamePrinterOptions(GAME_PRINTER_OPTIONS_PAPIER);
                    gamePrinterOptions(GAME_PRINTER_OPTIONS_PLAYER_2);
                    break;
                case 2:
                    gamePrinterOptions(GAME_PRINTER_OPTIONS_KAMIEN);
                    gamePrinterOptions(GAME_PRINTER_OPTIONS_PLAYER_2);
                    break;
                case 3:
                    gamePrinterOptions(GAME_PRINTER_OPTIONS_NOZYCE);
                    gamePrinterOptions(GAME_PRINTER_OPTIONS_PLAYER_2);
                    break;
            }

            switch (whoWin){
                case 1:
                    player1.addPoint();
                    break;
                case 2:
                    player2.addPoint();
                    break;
                case 3:
                    remis++;
                    //todo wyświetlenie informacji o remisie
            }


        }while (endGamePoints >= player1.getPoint()||endGamePoints>=player2.getPoint()||(gameBreak == true));
    }

    public int getRemis() {
        return remis;
    }

    public int getWins() {
        return player1.getPoint();
    }
    public int getFails() {
        return player2.getPoint();
    }
}
