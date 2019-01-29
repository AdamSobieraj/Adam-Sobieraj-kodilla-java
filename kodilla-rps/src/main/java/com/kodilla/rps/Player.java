package com.kodilla.rps;

public abstract class Player {

    protected String name;
    protected String surname;
    protected Integer move;

    private Integer point= new Integer(0);

    public Player(String name, String surname) {
        this.surname = surname;
        this.name = name;
       }

    public abstract int getMove();

    public void addPoint(){
        point++;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getPoint() {
        return point;
    }

    public void setMove(Integer move) {
        this.move = move;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
