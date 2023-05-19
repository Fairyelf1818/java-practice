package com.studyopedia.copy2;

public class Airplane { // THe lab test to be submitted
	protected String name; // GoOd PrAtIcE to make them protected
    protected int length;
    protected String manufacturer;
    protected static int count;

    public Airplane(String name, int length, String manufacturer) { //Constructor 
        this.name = name;
        this.length = length;
        this.manufacturer = manufacturer; // Basically initializing stuff
        count++;
    }

    public void fly() { // Base function to give flying vehicle info :(
        System.out.println("The airplane named " + name + " which was manufacured by "+manufacturer+" is currently flying. It is "+length+" feet long"); // Output
    } 
}
