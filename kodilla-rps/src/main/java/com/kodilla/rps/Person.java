package com.kodilla.rps;

public class Person {

    private String name;
    private String surname;
    private String Score;


    Person( String name, String surname, String Score) {
        this.name = name;
        this.surname = surname;
        this.Score = Score;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    String getScore() {
        return Score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setScore(String score) {
        this.Score = score;
    }

    @Override
    public int hashCode(){
        return  Integer.parseInt(name.substring(0,5)) +
                Integer.parseInt(surname.substring(0,5));
    }

    @Override
    public boolean equals(Object o){
        final Person p = (Person) o;
        return this.name.equals(p.name) && this.surname.equals(p.surname);

    }

    @Override
    public String toString() {
        return "\n\nName: " + getName() + "\nSurname: " + getSurname() + "\nScore: " + getScore();
    }

}
