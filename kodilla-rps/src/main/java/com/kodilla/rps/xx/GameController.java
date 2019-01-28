package com.kodilla.rps.xx;

public class GameController {

    private Player player1;
    private Player player2;

    private Game game;

    private int endGamePoints;

    public GameController(Player player1, Player player2, Game game, int endGamePoints) {
        this.player1 = player1;
        this.player2 = player2;
        this.game = game;
        this.endGamePoints = endGamePoints;
    }

    public void runGame(){

        do {

            int player1Move = player1.getMove();
            int player2Move = player2.getMove();

            int whoWin = game.whoWin(player1Move,player2Move);

            switch (whoWin){
                case -1:
                    player1.addPoint();
                    break;
                case 1:
                    player2.addPoint();
                    break;
                case 0:
                    //todo wyświetlenie informacji o remisie
            }


        }while (endGamePoints >= player1.getPoint()||endGamePoints>=player2.getPoint());
    }
}
