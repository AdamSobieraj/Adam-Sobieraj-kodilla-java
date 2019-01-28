package com.kodilla.rps.xx;

public abstract class Player {

    private String name;
    private Integer point= new Integer(0);

    public Player(String name) {
        this.name = name;
       }

    public abstract int getMove();

    public Integer getPoint() {
        return point;
    }

    public void addPoint(){
        point++;
    }

}
