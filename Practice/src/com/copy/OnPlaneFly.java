package com.studyopedia.copy;

public class OnPlaneFly {
// WHAT WILL HAPPEN WHEN YOU START THE PLANE (I MEAN RUN THE PROJECT)
	public static void main(String[] args) {//Program actually begins to run here
        Airplane[] airp = new Airplane[4]; // THis indicates that the array will hold 4 things. I despise Arrays with every fiber of my being

        airp[0] = new Airplane("Luxury Golden Airplane",15, "Elite Travels"); 
        airp[1] = new Jet("B11 Strike Force", 10, "Caldera", 28000);
        airp[2] = new Jet("Hydra", 5, "Hover jet", 28989);
        airp[3] = new Jet("Lazer PQ-997", 9, "Cache and carry", 7600); // My favorite jet in GTA online, probably spell wrong

        for (Airplane airplane : airp) {
            airplane.fly(); // calls the function
        }
    }
}
