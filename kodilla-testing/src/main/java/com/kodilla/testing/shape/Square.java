package com.kodilla.testing.shape;

public class Square implements Shape {

    private double field;
    private String shapeName;
    private double a;
    private double b;

    public void getShapeName(){
        System.out.println("Figure name: "+shapeName);
    }
    public double getField(){
        field = a * b;
        return this.field;
    }

    public Square(double a, double b, String shapeName) {
        this.a = a;
        this.b = b;
        this.shapeName = shapeName;
    }
    @Override
    public String toString(){
        return shapeName;
    }
}
