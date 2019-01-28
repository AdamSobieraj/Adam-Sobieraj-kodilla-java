package com.kodilla.rps.xx;

public class Game {
    //tablica tab
    int[][] rules = {

            {1, 0 , -1},{-1, 1, 0},{0, -1 ,1}
    };

    public int whoWin(int movePlayer1, int movePlayer2){
        return rules[movePlayer1][movePlayer2];

    }
}
