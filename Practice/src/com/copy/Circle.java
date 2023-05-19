package com.studyopedia.copy;

public class Circle extends Shape {
    private double radius;

    public Circle(String name, String category, double radius) {
        super(name, category);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }
}
