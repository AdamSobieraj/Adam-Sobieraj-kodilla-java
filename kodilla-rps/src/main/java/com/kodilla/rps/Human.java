package com.kodilla.rps;

public class Human extends Player{

    private Integer moveOfUser;

    public Human(String name, String surname) {
        super(name, surname);
    }

    @Override
    public int getMove() {
        return moveOfUser;
    }

    @Override
    public int hashCode(){

        return  name.hashCode() + surname.hashCode();
    }

    @Override
    public boolean equals(Object o){
        final Player p = (Player) o;
        return this.name.equals(p.name) && this.surname.equals(p.surname);
    }

    @Override
    public String toString() {
        return "\n\nName: " + getName() + "\nSurname: " + getSurname() + "\nScore: " + getPoint();
    }
}
