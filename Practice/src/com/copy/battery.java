package com.studyopedia.copy;

//
//public class battery {
//	private String brand;
//	private double voltage;
//	private double weight;
//	
//	battery(String brand, double voltage,double weight){ // First constructor
//		this.brand = brand;
//		this.voltage = voltage;
//		this.weight = weight;
//		
//		brand = "0";
//		voltage = 0;
//		weight = 0;
//		
//		System.out.println("Hello");
//	}
//	battery(){}
//	
//	public void showDetails(){}
//}

/*package com.studyopedia;
import java.util.Scanner;

public class battery {
    private String brand;
    private double voltage;
    private double weight;
    
    public battery() {
        this.brand = "";
        this.voltage = 0;
        this.weight = 0;
        System.out.println("Hello");
    }
    
    public battery(String brand, double voltage, double weight) {
        this.brand = brand;
        this.voltage = voltage;
        this.weight = weight;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public double getVoltage() {
        return voltage;
    }
    
    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public void showDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Voltage: " + voltage);
        System.out.println("Weight: " + weight);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        battery penlight = new battery();
        battery ninevolt = new battery();
        battery triple = new battery();
        
        System.out.println("Enter brand, voltage, and weight for penlight:");
        penlight.setBrand(input.nextLine());
        penlight.setVoltage(input.nextDouble());
        penlight.setWeight(input.nextDouble());
        input.nextLine(); 
        
        System.out.println("Enter brand, voltage, and weight for ninevolt:");
        ninevolt.setBrand(input.nextLine());
        ninevolt.setVoltage(input.nextDouble());
        ninevolt.setWeight(input.nextDouble());
        input.nextLine(); 
        
        System.out.println("Enter brand, voltage, and weight for triple:");
        triple.setBrand(input.nextLine());
        triple.setVoltage(input.nextDouble());
        triple.setWeight(input.nextDouble());
        input.nextLine(); 
        
        System.out.println("Penlight details:");
        System.out.println("Brand: " + penlight.getBrand());
        System.out.println("Voltage: " + penlight.getVoltage());
        System.out.println("Weight: " + penlight.getWeight());
        System.out.println();
        
        System.out.println("Ninevolt details:");
        System.out.println("Brand: " + ninevolt.getBrand());
        System.out.println("Voltage: " + ninevolt.getVoltage());
        System.out.println("Weight: " + ninevolt.getWeight());
    }
}*/