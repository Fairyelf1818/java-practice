package com.studyopedia.copy;

import javax.swing.JOptionPane;

public class Menu{
	public static void main(String args[]) {
		int heading = Integer.parseInt(JOptionPane.showInputDialog("Menu - Press 1 to log in and 2 to sign up"));

		
		if(heading == 1) {
			JOptionPane.showMessageDialog(null, "You chose: "+heading);
		}
		else if (heading == 2) {
			JOptionPane.showMessageDialog(null, "You chose: "+heading);
		}
		else {
			JOptionPane.showMessageDialog(null, "idk");
		}
	}
}