package com.studyopedia.copy;

public class Skyscraper extends building {
    private int numberOfFloors;
    private String name;

    public Skyscraper(int squareFoot, String location, int numberOfFloors, String name) {
        super(squareFoot, location);
        this.numberOfFloors = numberOfFloors;
        this.name = name;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Number of Floors: " + numberOfFloors);
        System.out.println("Name: " + name);
    }
}