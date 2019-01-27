package com.kodilla.rps;

public class RandNumber {
    private final int OPTION;

    public RandNumber(int OPTION) {
        this.OPTION = OPTION;
    }

    public int RandomNumberGenerator(){
        return  (int)(Math.random() * OPTION) + 1;
    }
}
