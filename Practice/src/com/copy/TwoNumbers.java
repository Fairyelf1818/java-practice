package com.studyopedia.copy;
import java.util.Scanner;

public class TwoNumbers {
	
	public static void main(String[] args) {
		
	Scanner ReadNumbers = new Scanner(System.in);
	
	System.out.println("The user should enter 2 numbers");
	
	System.out.println("Number 1: ");
	int num1 = ReadNumbers.nextInt();
	
	System.out.println(" Number 2:");
	int num2 = ReadNumbers.nextInt();
	
	int divide = num1/num2;
	int remaining = num1%num2;
	
	System.out.println("Answer is: "+divide+"."+remaining);
	
	}
	

}
