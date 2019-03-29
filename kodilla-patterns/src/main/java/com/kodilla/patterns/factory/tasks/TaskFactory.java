package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task makeTask(final String shapeClass) {
        switch (shapeClass) {
            case DRIVING:
                return new DrivingTask("Driving", "London","Car" );
            case PAINTING:
                return new PaintingTask("Painting", "Red", "View");
            case SHOPPING:
                return new ShoppingTask("Shopping", "Milk", 20.0);
            default:
                return null;
        }
    }
}
