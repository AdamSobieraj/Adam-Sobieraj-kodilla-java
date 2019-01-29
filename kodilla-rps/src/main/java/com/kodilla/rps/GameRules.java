package com.kodilla.rps;

public class GameRules {

    int[][] rules = new int[10][10];

    public void fillTable(){
        rules[1][1] = 3;
        rules[1][2] = 1;
        rules[1][3] = 1;

        rules[2][1] = 2;
        rules[2][2] = 3;
        rules[2][3] = 2;

        rules[3][1] = 2;
        rules[3][2] = 1;
        rules[3][3] = 3;
    }

    public int whoWin(int movePlayer1, int movePlayer2){
        return rules[movePlayer1][movePlayer2];
    }
}


/*
            {0, 0, 0},
            {1, 1 ,3},
            {1, 2 ,1},
            {1, 3 ,1},
            {2, 1, 2},
            {2, 2, 3},
            {2, 3 ,2},
            {3, 1, 2},
            {3, 2 ,1},
            {3, 3 ,3}

 */