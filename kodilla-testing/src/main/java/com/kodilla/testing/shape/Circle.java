package com.kodilla.testing.shape;

public class Circle implements Shape {

    private double field;
    private String shapeName;
    private double radiaus;

    public void getShapeName(){
        System.out.println("Figure name: "+shapeName);
    }
    public double getField(){
        field = Math.PI+Math.pow(radiaus, 2);
        return this.field;
    }

    public Circle(double radiaus, String shapeName) {
        this.radiaus = radiaus;
        this.shapeName = shapeName;
    }

    @Override
    public String toString(){
        return shapeName;
    }
}
