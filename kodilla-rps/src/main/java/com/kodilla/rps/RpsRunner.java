package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        Game theRPSGame = new Game();
        theRPSGame.menuRun();
        GameRules gameRules = new GameRules();
        gameRules.fillTable();
        Human human = new Human(theRPSGame.getPerName(), theRPSGame.getSurname());
        Computer computer = new Computer();

        GameController gameController = new GameController(human,computer,gameRules, theRPSGame.getToHowManyWins());

        while (true){
            gameController.runGame();
            theRPSGame.setGetUserPoints(human.getPoint());
            theRPSGame.setGetUserFails(human.getFails());
            theRPSGame.setGetUserDraw(human.getDraw());
            theRPSGame.menuRun();
        }
    }


}
