package com.kodilla.testing.shape;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShapeCollectorTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){ System.out.println("Test Case: end");}

    @Test
    public void testCaseAddFigure(){
        //Given
        ShapeCollector shape = new ShapeCollector();
        Circle circle1 = new Circle(2, "Circle");
        Square square1 = new Square(2, 2, "Square");
        Triangle triangle = new Triangle(2, 3, "Triangle");
        shape.addFigure(circle1);
        shape.addFigure(square1);
        shape.addFigure(triangle);
        //When
        int resoult = shape.getSize();
        //Then
        Assert.assertEquals(3, resoult);
    }

    @Test
    public void testCaseRemoveFigure(){
        //Given
        ShapeCollector shape = new ShapeCollector();
        Circle circle1 = new Circle(2, "Circle");
        Square square1 = new Square(2, 2, "Square");
        Triangle triangle = new Triangle(2, 3, "Triangle");
        shape.addFigure(circle1);
        shape.addFigure(square1);
        shape.addFigure(triangle);
        shape.removeFigure(circle1);
        //When
        int resoult = shape.getSize();
        //Then
        Assert.assertEquals(2, resoult);
    }

    @Test
    public void testCaseGetFigure(){
        //Given
        ShapeCollector shape = new ShapeCollector();
        Circle circle1 = new Circle(2, "Circle");
        Square square1 = new Square(2, 2, "Square");
        Triangle triangle = new Triangle(2, 3, "Triangle");
        shape.addFigure(circle1);
        shape.addFigure(square1);
        shape.addFigure(triangle);
        //When
        shape.getFigure(0);
        String resoult = shape.getGettingFigure();
        //Then
        Assert.assertEquals(circle1.toString(), resoult);
    }

    @Test
    public void testCaseShowFigures(){
        //Given
        ShapeCollector shape = new ShapeCollector();
        Circle circle1 = new Circle(2, "Circle");
        Square square1 = new Square(2, 2, "Square");
        Triangle triangle = new Triangle(2, 3, "Triangle");
        shape.addFigure(circle1);
        shape.addFigure(square1);
        shape.addFigure(triangle);
        //When
        shape.showFigures();
        String resoult = shape.getShowFigures();
        String base = circle1.toString()+ " "+ square1.toString()+" "+triangle.toString();
        //Then
        Assert.assertEquals(resoult, base);
    }
}
