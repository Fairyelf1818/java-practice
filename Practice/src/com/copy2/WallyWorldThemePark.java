package com.studyopedia.copy2;

import java.util.Scanner;

public class WallyWorldThemePark {
	public static void main(String[] args) {
		Scanner ReadNumbers = new Scanner(System.in); //DECLARE SCANNER
		
		System.out.println("Please enter your age"); // Gets age from user
		int age = ReadNumbers.nextInt();
		
		System.out.println("Please enter your height"); // Gets height from user
		double height = ReadNumbers.nextDouble();
		
		
		// Checks Age
		if(age >=16) {
			System.out.println("Please pay $15 for your ticket");
		}
		else if (age <16 && age >=6) {
			System.out.println("Please pay $10 for your ticket");
		}
		else if(age<=5) {
			System.out.println("Ages 5 and under go free");
		}
		else {
		System.out.println("UNEXPECTED ERROR");
		}
		
		// Checks Height
		if(height <3.5) {
			System.out.println("You can go on 5 rides");
		}
		else if(height < 5 & height >= 3.5) {
			System.out.println("You can go on 10 rides");
		}
		else if (height>= 5) {
			System.out.println("You can go on 15 rides");
		}
		}

}
g