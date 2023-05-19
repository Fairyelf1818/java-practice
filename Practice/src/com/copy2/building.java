package com.studyopedia.copy2;

public class building {
    protected int squareFoot;
    protected String location;

    public building(int squareFoot, String location) {
        this.squareFoot = squareFoot;
        this.location = location;
    }

    public void display() {
        System.out.println("Square Foot: " + squareFoot);
        System.out.println("Location: " + location);
    }
}
