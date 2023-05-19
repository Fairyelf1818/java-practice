package com.studyopedia.copy2;

public class Shoebox extends box {
    private String material; // instance variable
    private final int size; // constant data member

    // Default constructor
    public Shoebox() {
        super();
        this.material = "";
        this.size = 0;
    }

    // Primary constructor
    public Shoebox(double length, double width, double height, String material, int size) {
        super(length, width, height);
        this.material = material;
        this.size = size;
    }

    // Getter and setter for material
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}


