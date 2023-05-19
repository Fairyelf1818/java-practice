package com.studyopedia.copy;

public class Main {
    public static void main(String[] args) {
        Animal lion = new Lion("Simba", 200, "Africa");
        Animal aardvark = new Ardvark("Arthur", 100, "South America");

        lion.who();         // prints "I am a lion named Simba, weighing 200.0 pounds, and I live in Africa."
        aardvark.who();     // prints "I am an aardvark named Arthur, weighing 100.0 pounds, and I live in South America."
        //--------------------------------------------------------------------------
        System.out.println("-------------------------------------------------------------------------");
        Shape circle = new Circle("Circle", "2D", 5.0);
        Shape square = new Square("Square", "2D", 7.0);
        Shape raTriangle = new RATriangle("Right Angled Triangle", "2D", 3.0, 4.0);
        Shape rectangle = new Rectangle("Rectangle", "2D", 6.0, 8.0);

        System.out.println("Area of " + circle.getName() + " is " + circle.calcArea());
        System.out.println("-------------------------------------------------------------------------");
        
        
    }
}
