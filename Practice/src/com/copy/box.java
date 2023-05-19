package com.studyopedia.copy;

import java.util.Scanner;

public class box {
    protected static int count = 0; // static integer member
    protected double length, width, height; // instance variables

    // Default constructor
    public box() {
        this.length = 0;
        this.width = 0;
        this.height = 0;
        count++;
    }

    // Constructor with parameters
    public box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
        count++;
    }

    // Getters and setters for length, width, height
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Getter for count
    public static int getCount() {
        return count;
    }
}

