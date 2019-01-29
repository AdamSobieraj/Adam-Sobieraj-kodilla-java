package com.kodilla.rps;

import java.util.Random;

public class Computer extends Player {

    private static final Random random = new Random();

    public Computer() {
        super("Computer", "Computer");
    }

    @Override
    public int getMove() {
        return random.nextInt(3);
    }
}
