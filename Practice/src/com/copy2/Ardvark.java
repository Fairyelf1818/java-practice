package com.studyopedia.copy2;

public class Ardvark extends Animal {
    private String location;

    public Ardvark(String name, double weight, String location) {
        super(name, weight);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void who() {
        System.out.println("I am an aardvark named " + getName() + ", weighing " + getWeight() + " pounds, and I live in " + location + ".");
    }
}