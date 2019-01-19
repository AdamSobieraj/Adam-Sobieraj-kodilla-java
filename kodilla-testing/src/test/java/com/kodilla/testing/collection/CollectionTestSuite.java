package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

    @Before
    public void before(){

        System.out.println("Test Case: Check odd numbers empty list");
        System.out.println("Test Case: Check odd numbers filtering list");
    }
    @After
    public void after(){

        System.out.println("Test Case: Check odd numbers empty list end");
        System.out.println("Test Case: Check odd numbers list end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList (){
        //Given
        ArrayList<Integer> testZeroList = new ArrayList<>();
        OddNumbersExterminator oddNumbers = new OddNumbersExterminator();
        //When
        oddNumbers.exterminate(testZeroList);
        System.out.println("Data input to test, ArrayList lenght :" + testZeroList.size());
        //Then
        Assert.assertEquals(testZeroList, oddNumbers.exterminate(testZeroList));
    }
    @Test
    public void testOddNumbersExterminatorNormalList (){
        //Given
        ArrayList<Integer> testList = new ArrayList<>();
        ArrayList<Integer> resoult  = new ArrayList<>();
        OddNumbersExterminator oddNumbersCheck = new OddNumbersExterminator();
        testList.add(3);
        testList.add(2);
        testList.add(6);
        testList.add(7);
        testList.add(13);
        testList.add(22);
        testList.add(11);
        //compare Array
        resoult.add(2);
        resoult.add(6);
        resoult.add(22);
        //When
        oddNumbersCheck.exterminate(testList);
        System.out.println("Function resoult");
        for(Integer tmp: oddNumbersCheck.exterminate(testList)){
            System.out.println(tmp);
        }
        System.out.println("");
        //Then
        Assert.assertEquals(oddNumbersCheck.exterminate(testList).size(), resoult.size());
    }
}
