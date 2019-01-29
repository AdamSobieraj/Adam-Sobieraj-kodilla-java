package com.kodilla.rps;

import static com.kodilla.rps.ConsoleManager.*;
import static com.kodilla.rps.ConsoleManager.gettingConsoleInputString;
import static com.kodilla.rps.GamePrintSelection.*;
import static com.kodilla.rps.GamePrinterOptions.*;

public class GameController {

    private Player player1;
    private Player player2;
    private Integer playerOption;
    private int draw;
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

            String userInput = gettingConsoleInputString();

            if (userInput.equals("x")){
                gameBreak = true;
                break;
            }else if (userInput.equals("n")){
                player1.setPoint(0);
                player2.setPoint(0);
                draw = 0;
                gameBreak = false;
            }else{
                playerOption = Integer.parseInt(userInput);
            }

            player1.setMove(playerOption);

            int player1Move = player1.getMove();
            int player2Move = player2.getMove();
            System.out.println(player2Move);

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
                    default:
                        System.out.println("Error");
            }
            int whoWin = game.whoWin(player1Move,player2Move);

            switch (whoWin){
                case 1:
                    player1.addPoint();
                    break;
                case 2:
                    player2.addPoint();
                    break;
                case 3:
                    draw++;
            }

            statistics();

        }while (endGamePoints >= player1.getPoint()||(gameBreak == true));

        player1.setFails(player2.getPoint());
        player1.setDraw(draw);

    }

    private void statistics(){
        gamePrinterOptions(GAME_PRINTER_OPTIONS_WINS);
        objectPrinter(player1.getPoint());
        gamePrinterOptions(GAME_PRINTER_OPTIONS_LOST);
        objectPrinter(player2.getPoint());
        gamePrinterOptions(GAME_PRINTER_OPTIONS_REMIS);
        objectPrinter(draw);


    }
}
