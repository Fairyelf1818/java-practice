package com.studyopedia.copy;

public abstract class Language {
	protected String origin;
	protected String region;
	protected int age;
	
	public Language(String origin, String region, int age ) {
		this.origin = origin;
		this.region = region;
		this.age = age;
	}
	
	
	// SETTER METHODS
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	// GETTER METHODS
	public String getOrigin() {
		return origin;
	}
	public String getRegion() {
		return region;
	}
	public int getAge() {
		return age;
	}
	
	// SPEAK METHOD
	public abstract void speak();

}
