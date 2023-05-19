package com.studyopedia.copy2;

public class Lion extends Animal {
    private String location;

    public Lion(String name, double weight, String location) {
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
        System.out.println("I am a lion named " + getName() + ", weighing " + getWeight() + " pounds, and I live in " + location + ".");
    }
}



