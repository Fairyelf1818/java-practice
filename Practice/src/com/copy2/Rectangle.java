package com.studyopedia.copy2;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String name, String category, double length, double width) {
        super(name, category);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double calcArea() {
        return length * width;
    }
}