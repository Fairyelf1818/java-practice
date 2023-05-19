package com.copy2;

import java.util.Scanner;

public class ppaugust2015question2 {
	// This program will accept a 6 digit integer and reverse the order
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner numbers = new Scanner(System.in);
		
		System.out.println("Please enter a 6 digit number");
		int num = numbers.nextInt();
		String numm = Integer.toString(num); // Converting the String to An integer to easily determine its length
		String theReversednum = "";
		if (numm.length() == 6) { // If the length is 6 then it completes the following lines of code
			for (int i = 0; i < numm.length(); i++) {
				  theReversednum = numm.charAt(i) + theReversednum;
				}
			System.out.println("The reversed number is: " + theReversednum);
		}else { // Or else it prints the following statement
			System.out.println("Please eneter a 6 digit number and try again");
		}
	}

}
