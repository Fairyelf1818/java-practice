package com.studyopedia.copy2;

public class Square extends Shape {
    private double length;

    public Square(String name, String category, double length) {
        super(name, category);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double calcArea() {
        return length * length;
    }
}
