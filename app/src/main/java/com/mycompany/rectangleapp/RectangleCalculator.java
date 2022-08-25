package com.mycompany.rectangleapp;

public class RectangleCalculator {
    //Field
    private Rectangle rectangle;

    //constructor
    public RectangleCalculator() {

    }

    //Method encapsulating capability to calculate area
    public  double calculateArea(Rectangle rectangle) {
        double length=rectangle.getLength();
        double breadth=rectangle.getBreadth();
        return length * breadth;
    }
}
