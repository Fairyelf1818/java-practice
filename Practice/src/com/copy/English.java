package com.studyopedia.copy;

public class English extends Language {
	protected int dictionary_size;
	public English(String origin, String region, int age, int dictionary_size) {
		super(origin, region, age);
		this.dictionary_size = dictionary_size;
		// TODO Auto-generated constructor stub
	}
	
	public void setDictionary_size(int dictionary_size) {
		this.dictionary_size = dictionary_size;
	}
	public int getDictionary_size() {
		return dictionary_size;
	}
	
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println(getOrigin()+" " +" "+getRegion()+" "+getAge()+" "+getDictionary_size()+" I love School! Not!");
	}
	

}
