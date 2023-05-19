package com.studyopedia.copy2;

public class French extends Language {
	
	protected String origin_country;
	
	public French(String origin, String region, int age, String origin_country) {
		super(origin, region, age);
		// TODO Auto-generated constructor stub
		this.origin_country = origin_country;
	}
	
	public void setOrigin_Country(String origin_country) { // Setter Method for this
		this.origin_country = origin_country;
	}
	
	public String getOrigin_country() {
		return origin_country;
	}
	
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println(getOrigin()+" " +" "+getRegion()+" "+getAge()+" "+getOrigin_country()+" Je voudrais bien un recu");
	}
	

}
