package com.studyopedia.copy;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayActitivy {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int position;
		double[] gpa = {.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5,.5};
		double sum = 0;
		
		System.out.println("Enter 2 numbers, the first number should tell where to put the second");
		
		//FOR LOOP TO ENTER DATA
		for (int i=0;i<5; i++) {
		System.out.println("Enter first number");
		position = scan.nextInt();
		if(position >=0 && position < gpa.length) {
			System.out.println("Enter second number");
			double grade = scan.nextDouble();
			if (grade >0 && grade <=4) {
				gpa[position] = grade;
			}
			else {
				System.out.println("Enter the correct gpa. between 1 and 4");
				i--;
			}
			//gpa[position] = scan.nextDouble();
				
		}else {
			System.out.println("Must be within subscript range");
			i--;
		}
		}
		//System.out.println("Enter second number");
		for(int i=0; i<gpa.length; i++) { //FOR LOOP TO PRINT DATA
			//System.out.println(gpa[i]);
			if(gpa[i] == 0) {
				System.out.println(gpa[i]+"Letter Grade U");
			}
			else if (gpa[i]==1) {
				System.out.println("Grade: "+gpa[i]+" Letter Grade D. The index is: "+ i);
				sum+=gpa[i];
			}
			else if (gpa[i]==2) {
				System.out.println("Grade: "+gpa[i]+" Letter Grade C. The index is: "+i);
				sum+=gpa[i];
			}
			else if (gpa[i]==3) {
				System.out.println("Grade: "+gpa[i]+" Letter Grade B. The index is: "+i);
				sum+=gpa[i];
			}
			else if (gpa[i]==4) {
				System.out.println("Grade: "+gpa[i]+" Letter Grade A. The index is: "+i);
				sum+=gpa[i];
			}
			else {
				//System.out.println("Error");
			}
			
			
		}
		System.out.println("The average is: "+sum/5);

	}

}
