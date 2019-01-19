package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

   public List<Integer> exterminate(ArrayList<Integer> numbers){

       ArrayList<Integer> oddArrayList = new ArrayList<>();

       for(Integer elementsOfArray: numbers){
           if(elementsOfArray%2==0){
               oddArrayList.add(elementsOfArray);
           }
       }

       return oddArrayList;
   }

}
