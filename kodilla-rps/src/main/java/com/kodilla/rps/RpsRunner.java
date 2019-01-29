package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        Game theRPSGame = new Game();
        theRPSGame.menuRun();
        GameRules gameRules = new GameRules();
        Human human = new Human(theRPSGame.getPerName(), theRPSGame.getSurname());
        Computer computer = new Computer();

        GameController gameController = new GameController(human,computer,gameRules, theRPSGame.getToHowManyWins());
        gameController.runGame();
        theRPSGame.menuRun();
    }


}
