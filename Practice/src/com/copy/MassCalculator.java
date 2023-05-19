package com.studyopedia.copy;
import java.util.Scanner;

public class MassCalculator {
	public static void main(String[] args) {
		Scanner ReadNumbers = new Scanner(System.in); //DECLARE SCANNER
	
		System.out.println("Enter your car's weight in kilograms.");
		
		double carWeight = ReadNumbers.nextDouble();
		
		System.out.println("Want to calculate the weight in Newtons on Earth or on the moon?");
		
		System.out.println("If you wish to calculate the weight on Earth type 1 if on the moon type 2");
		
		int weightType = ReadNumbers.nextInt();
		
		double earthWeight = carWeight * 9.81;
		double moonWeight = ((carWeight) * (9.81)) / 6;
		
		
		//IF STATEMENT
		if(weightType == 1) {
			System.out.println("The weight on the Earth is: " + earthWeight);
		} else if(weightType ==2) {
			System.out.println("The weight on the moon is: " + moonWeight);
		}
		else {
			System.out.println("Incorrect value placed");
		}
		
		}
	
	
}
