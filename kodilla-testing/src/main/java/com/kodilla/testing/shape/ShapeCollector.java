package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> collectionOfSchapes = new ArrayList<>();
    private int size ;
    private Object figure;
    private String showFigures;
    private String gettingFigure;
    private int i=0;

    public void addFigure(Shape shape){
        collectionOfSchapes.add(shape);
    }
    public void removeFigure(Shape shape){
        collectionOfSchapes.remove(shape);
    }
    public void getFigure(int n){
        Object listElement = collectionOfSchapes.get(n);
        gettingFigure = listElement.toString();
    }
    public void showFigures(){
        showFigures = "";
        for (Object tmpElement: collectionOfSchapes){
            if((i!=0)&&( i < collectionOfSchapes.size())){
                showFigures = showFigures +" "+ tmpElement.toString();
            }else {
                showFigures = showFigures + tmpElement.toString();
            }
            i++;
        }
    }

    public int getSize() {
        return size = collectionOfSchapes.size();
    }

    public Object getFigure() {
        return figure;
    }

    public String getShowFigures() {
        return showFigures;
    }

    public String getGettingFigure() {
        return gettingFigure;
    }
}
