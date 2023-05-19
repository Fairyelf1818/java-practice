package com.studyopedia.copy;

public class RATriangle extends Shape {
    private double base;
    private double height;

    public RATriangle(String name, String category, double base, double height) {
        super(name, category);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calcArea() {
        return 0.5 * base * height;
    }
}
