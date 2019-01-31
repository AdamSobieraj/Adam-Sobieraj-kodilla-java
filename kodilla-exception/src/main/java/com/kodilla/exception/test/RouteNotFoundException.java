package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class RouteNotFoundException extends Exception {

    public static void main(String[] args) {
        Map<Flight,Boolean> tmpMap = new HashMap<>();

        FindFlight findFlight = new FindFlight();

        Flight flight1 = new Flight("Berlin", "Zurich");
        Flight flight2 = new Flight("Zagrzeb", "Katowice");
        Flight flight3 = new Flight("Belfast", "Sweeden");
        Flight flight4 = new Flight("Rome", "Greece");

        tmpMap.put(flight1, true);
        tmpMap.put(flight2, true);
        tmpMap.put(flight3, false);

        findFlight.addToMap(tmpMap);

        //Working
        try{
            findFlight.findFilght(flight1);
        }catch (Exception e){
            System.out.println("Error Occured");
        }finally {
            System.out.println("This is the end of task");
        }

        //Error
        try{
            findFlight.findFilght(flight4);
        }catch (Exception e){
            System.out.println("Error Occured");
        }finally {
            System.out.println("This is the end of task");
        }
    }


}
