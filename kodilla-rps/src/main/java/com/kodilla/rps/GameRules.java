package com.kodilla.rps;

public class GameRules {

    int[][] rules = {
            {1, 1 , 3},{2, 2, 3},{1, 2 ,1},{1, 3 , 2},{2, 1, 2},{2, 3 ,1},{3, 1, 1},{3, 2 ,2}
    };

    public int whoWin(int movePlayer1, int movePlayer2){
        return rules[movePlayer1][movePlayer2];
    }
}
//{1, 0 , -1},{-1, 1, 0},{0, -1 ,1}