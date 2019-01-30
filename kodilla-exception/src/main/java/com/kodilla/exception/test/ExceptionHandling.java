package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try{
            secondChallenge.probablyIWillThrowException(3,0);
        }catch (Exception e){
            System.out.println("Error Occured");
        }finally {
            System.out.println("Dthis is the end of task");
        }
    }
}
