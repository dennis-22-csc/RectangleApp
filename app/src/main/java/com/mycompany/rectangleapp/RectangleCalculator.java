package com.mycompany.rectangleapp;

public class RectangleCalculator {
    private final Rectangle rectangle;
    private double area;

    public RectangleCalculator(Rectangle rectangle){
        this.rectangle=rectangle;
    }


    public RectangleCalculator calculateArea(){
        area=rectangle.getLength()* rectangle.getBreadth();
        return this;
    }
    public double getArea(){
        return area;
    }


}
