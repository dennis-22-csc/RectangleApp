package com.mycompany.rectangleapp;

public class Rectangle {
    //Fields
    private double length;
    private double breadth;

    //Constructor
    public Rectangle(double length, double breadth) {
        this.length=length;
        this.breadth=breadth;
    }

    //Method to get the length
    public double getLength() {
        return length;
    }

    //Method to get breadth
    public double getBreadth(){
        return breadth;
    }

}
