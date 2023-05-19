package com.studyopedia.copy;

import java.util.Scanner;

public class TwoNumbersComparison {
	public static void main(String[] args) {
		Scanner ReadNumbers = new Scanner(System.in);
		
		System.out.println("Please Give:");
		System.out.println("First Number");
		int firstnum = ReadNumbers.nextInt();
		System.out.println("Second Number");
		int secondnum = ReadNumbers.nextInt();
		int sum = 0;
		
		if(firstnum > secondnum) {
			sum = firstnum + secondnum;
			System.out.println("The first number "+firstnum+" is larger and the sum is " +sum);
		}
		else if(secondnum > firstnum) {
			sum = firstnum + secondnum;
			System.out.print("The second number "+secondnum+" is larger and the sum is "+sum);
		}
		else if(firstnum == secondnum) {
			sum = firstnum + secondnum;
			System.out.println("Both numbers are equal. The sum is "+sum);
		}
		else {
			System.out.println("I don`t know chi-");
		}
	}

}
