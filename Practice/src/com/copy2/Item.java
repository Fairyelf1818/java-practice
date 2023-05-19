package com.studyopedia.copy2;

import java.util.Scanner;

public class Item {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        try { // Try this block of code
            System.out.print("Enter the first number: ");
            int num1 = keyboard.nextInt();
            System.out.print("Enter the second number: ");
            int num2 = keyboard.nextInt();
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) { // If something goes wrong put this
            System.out.println("You cannot divide by zero. " + e);
        } finally { // If all goes well, supposed to ignore catch and print finally  --- It does not though
            System.out.println("The finally block was executed.");
        }
    }
}

