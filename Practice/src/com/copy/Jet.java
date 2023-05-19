package com.studyopedia.copy;

public class Jet extends Airplane {
	public int engine_size; // At this point chile

    public Jet(String name, int length, String manufacturer, int engine_size) {
        super(name, length, manufacturer);
        this.engine_size = engine_size; // Size of the jet`s engine?
    }

    @Override
    public void fly() { //Overriding the original one
        super.fly();//referencing back to origina one?
        System.out.println("This is a war jet whose engine size is: " + engine_size +" litres");
    }
    
    

}
