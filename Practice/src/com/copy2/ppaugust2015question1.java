package com.copy2;

import java.util.Scanner;

public class ppaugust2015question1 {

	// This Program determines if the given word is a palindrome
	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner word = new Scanner(System.in)) {
			System.out.println(" This program will check if the inserted word is a palindrome");
			System.out.println("Please enter a word");
			String theword = word.nextLine();
			String theReversedword = "";

			for (int i = 0; i < theword.length(); i++) {
				  theReversedword = theword.charAt(i) + theReversedword;
				}
			
			if (theword.equals(theReversedword)) { // The .equals function compares the content of both strings to check if they are equal
				System.out.println("This word is a palindrome");
				System.out.println(theReversedword);
			}else {
				System.out.println("This word is definitely not a palindrome");
			}
		}
		
		
			//System.out.println("Reversed string: "+ theReversedword);

	}

}
